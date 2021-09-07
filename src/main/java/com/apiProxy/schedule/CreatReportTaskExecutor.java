package com.apiProxy.schedule;

import com.apiProxy.controller.JacocoController;
import com.apiProxy.exception.ServerException;
import com.apiProxy.mbg.po.Jacoco;
import com.apiProxy.model.UploadFile;
import com.apiProxy.service.JacocoServer;
import com.apiProxy.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author：hem
 * @Date：6/26/21 6:55 下午
 */
@Slf4j
@Component
public class CreatReportTaskExecutor {
    private final BlockingQueue<Jacoco> testTaskQueue = new LinkedBlockingQueue<>();

    private Thread executeTestTaskThread;

    @Value("${gitHost}")
    private String gitHost;
    @Value("${static-location}/upload/exec")
    private String exexPath;
    @Value("${gitToken}")
    private String gitToken;
    @Autowired
    private JacocoServer jacocoServer;


    public CreatReportTaskExecutor(){

        executeTestTaskThread = new Thread(() -> {
            Jacoco jacoco;
            while (true) {
                try {
                    jacoco = testTaskQueue.take(); // 没有任务，线程阻塞在此
                } catch (InterruptedException e) {
                    // 调用executeTestTaskThread.interrupt()可以执行到这里
                    log.info("停止获取任务");
                    break;
                }
                try {
                    executeTask(jacoco);
                } catch (Throwable e) {
                    log.error("执行任务出错, jacocoId: {}", jacoco.getId(), e);
                }
            }
        });
        executeTestTaskThread.start();
    }

    public void commitTestTask(Jacoco jacoco) {
        if (!testTaskQueue.offer(jacoco)) {
            throw new RuntimeException(String.format("提交任务失败, jacocoId:{}",jacoco.getId()));
        }
    }

    private void executeTask(Jacoco jacoco){
        //复制时间段内的exec文件
        cpExecFileToRead(jacoco.getJacocoProjectName(),jacoco.getStartTime(),jacoco.getEndTime());
        File ready = new File(exexPath+File.separatorChar+jacoco.getJacocoProjectName()+"/ready");
        if (!ready.exists()){
            jacoco.setDescription(jacoco.getJacocoProjectName()+"未上传过exec文件");
            jacoco.setTaskStatus(2);
            jacocoServer.update(jacoco);
            throw new RuntimeException(String.format(jacoco.getJacocoProjectName()+"未上传过exec文件"));
        }
        cloneAndInstallProject(jacoco);

        if (!CollectionUtils.isEmpty(jacoco.getChildrens())){
            jacoco.getChildrens().stream().forEach(jacoco1 -> {
                jacoco1.setId(jacoco.getId());
                cloneAndInstallProject(jacoco1);
            });
        }

        if (CollectionUtils.isEmpty(Arrays.asList(ready.listFiles()))){
            jacoco.setDescription("时间段内没有统计到覆盖率");
            jacoco.setTaskStatus(2);
            jacocoServer.update(jacoco);
            throw new RuntimeException(String.format("时间段内没有统计到覆盖率"));
        }
        //合并exec文件
        JacocoMergeDump jacocoMergeDump = new JacocoMergeDump(ready.getPath());
        try {
            jacocoMergeDump.executeMerge();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        //生成报告
        ReportGenerator reportGenerator = new ReportGenerator(gitToken,jacoco.getJacocoProjectName());
        String reportPth = "";
        try {
            reportPth = reportGenerator.create(jacoco);
        }catch (IOException e){
            log.error(e.getMessage());
            jacoco.setDescription(e.getMessage());
        }
        if (reportPth.startsWith("static")){
            reportPth = StringTools.substringAfter(reportPth,"/").concat("/index.html");
        }
        jacoco.setReportPath(JacocoController.url+reportPth);
        jacoco.setTaskStatus(2);
        jacocoServer.update(jacoco);
    }


    private void cloneAndInstallProject(Jacoco jacoco){
        //从gitlab中克隆项目到服务器
        try {
            GitLabUtil.builder().setGitUrl(gitHost);
            GitLabUtil.builder().gitClone(jacoco.getGitclonePath());
        }catch (ServerException s){
            jacoco.setTaskStatus(2);
            jacoco.setDescription(s.getMessage());
            jacocoServer.update(jacoco);
            throw new RuntimeException(String.format("克隆项目失败, jacocoProjectName:{}",jacoco.getJacocoProjectName()));
        }

        //切换分支
        if (jacoco.getCompareType() == Jacoco.COMMIT){
            GitLabUtil.builder().gitCheckoutCommit(jacoco.getCurrentCommit(),jacoco.getJacocoProjectName());
        }else {
            GitLabUtil.builder().gitCheckoutBranch(jacoco.getCurrentBranch(),jacoco.getJacocoProjectName());
        }


        //判断项目是否从gitlab克隆，并执行maven构建命令，生产源码和编译后的class文件
        File file = new File(UploadFile.GIT_PROJECT_PATH+File.separatorChar+jacoco.getJacocoProjectName());
        if (file.exists()){
            try {
                String mvVersion = Terminal.execute("mvn -v");
                if (!mvVersion.contains("Apache Maven")){
                    jacoco.setTaskStatus(2);
                    jacoco.setDescription("服务器未安装maven命令");
                    jacocoServer.update(jacoco);
                    return;
                }
                String maven = Terminal.execute("mvn install -Dmaven.test.skip=true",file);
                String[] mavenInfos = maven.split("\n");
                boolean isSucces = false;
                for (String info:mavenInfos){
                    if (info.matches(".*BUILD SUCCESS.*")){
                        isSucces = true;
                    }
                }
                if (!isSucces){
                    jacoco.setTaskStatus(2);
                    jacoco.setDescription("build源码失败:");
                    jacocoServer.update(jacoco);
                    return;
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

    private void cpExecFileToRead(String jacocoProjectName, Date startTime, Date endTime){
        File execFile = new File(exexPath+File.separatorChar+jacocoProjectName);
        File ready = new File(execFile,"ready");
        if (ready.exists()){
            File[] files = ready.listFiles();
            for (File f:files){
                f.delete();
            }
        }
        if (execFile.exists()){
            File[] files =  execFile.listFiles();
            for (File f :files){
                if (f.isFile() && f.getName().contains(".exec")){
                    long time = Long.parseLong(StringTools.substringBefore(f.getName(),".exec"));
                    if (time>=startTime.getTime() && time <= endTime.getTime()){
                        try {
                            Terminal.execute("cp -r "+f.getName()+" ready/",false,execFile);
                        } catch (IOException e) {
                            log.error(e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
