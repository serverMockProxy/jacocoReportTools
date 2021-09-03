package com.apiProxy.utils;

import com.apiProxy.mbg.po.Jacoco;
import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.analysis.IBundleCoverage;
import org.jacoco.core.internal.diff.GitAdapter;
import org.jacoco.core.tools.ExecFileLoader;
import org.jacoco.report.*;
import org.jacoco.report.html.HTMLFormatter;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Author：hem
 * @Date：6/25/21 5:33 下午
 */
public class ReportGenerator {
    private File executionDataFile;
    private File reportDirectory;
    private ExecFileLoader execFileLoader;
    private String gitToken;
    private Map<IBundleCoverage, File> coverageSourceDirMap = new HashMap<>();
    public ReportGenerator(String gitToken,String projectName) {
        this.gitToken = gitToken;
        this.executionDataFile = new File("static/upload/exec/"+projectName+"/ready", "jacoco.exec");
        this.reportDirectory = new File("static/frontend/jacoco/"+projectName, String.valueOf(new Date().getTime()));
    }

    public String create(Jacoco jacoco) throws IOException {
        this.loadExecutionData();
        //处理父模块
        setCoverageSourceDirMap(jacoco);
        //处理子模块
        if (!CollectionUtils.isEmpty(jacoco.getChildrens())){
            for (Jacoco jacoco1:jacoco.getChildrens()){
                setCoverageSourceDirMap(jacoco1);
            }
        }
        List<IReportVisitor> visitors = new ArrayList<>();
        createCoverageList(visitors);
        createReportFromList(coverageSourceDirMap,visitors,"代码覆盖率报告");
        return reportDirectory.getPath();
    }


    private void setCoverageSourceDirMap(Jacoco jacoco) throws IOException {
        switch (jacoco.getCompareType()){
            case Jacoco.COMMIT:
                analyzeStructure("gitProject/"+jacoco.getJacocoProjectName(),jacoco.getCurrentCommit(),
                        jacoco.getCompareCommit(),jacoco.getCurrentBranch());
                break;
            case Jacoco.BRANCH:
                analyzeStructure("gitProject/"+jacoco.getJacocoProjectName(),jacoco.getCurrentBranch(),
                        jacoco.getCompareBranch(),"false");
                break;
            case Jacoco.ALL:
                analyzeStructure("gitProject/"+jacoco.getJacocoProjectName(),jacoco.getCurrentBranch(),
                        jacoco.getCurrentBranch(),"false");
                break;
        }
    }

    private void createCoverageList(List<IReportVisitor> visitors) throws IOException {
        for(int i=0; i<coverageSourceDirMap.size(); i++){
            // 创建报告生成容器
            HTMLFormatter htmlFormatter = new HTMLFormatter();
            IReportVisitor visitor = htmlFormatter
                    .createVisitor(new FileMultiReportOutput(reportDirectory));

            // 访问标记覆盖信息
            visitor.visitInfo(this.execFileLoader.getSessionInfoStore().getInfos(),
                    this.execFileLoader.getExecutionDataStore().getContents());
            visitors.add(visitor);
        }
    }

    public void createReportFromList(Map<IBundleCoverage, File> coverageSourceDirMap, List<IReportVisitor> visitors, String appName) throws IOException{
        MultiReportVisitor mrv = new MultiReportVisitor(visitors);
        IReportGroupVisitor irgv = mrv.visitGroup(appName);
        for(Map.Entry<IBundleCoverage, File> iBundleCoverageFileEntry : coverageSourceDirMap.entrySet()){
            irgv.visitBundle(iBundleCoverageFileEntry.getKey(),
                    new DirectorySourceFileLocator(iBundleCoverageFileEntry.getValue(), "utf-8", 4));
        }
        mrv.visitEnd();
    }

    private void loadExecutionData() throws IOException {
        this.execFileLoader = new ExecFileLoader();
        this.execFileLoader.load(this.executionDataFile);
    }

    private void analyzeStructure(String gitPath, String current, String base, String branch) throws IOException {
        GitAdapter.setCredentialsProvider("oauth2", gitToken);
        CoverageBuilder coverageBuilder = null;
        List<String> srcAndClassPath = new ArrayList();
        getModulSrc(gitPath,srcAndClassPath);
        if (!CollectionUtils.isEmpty(srcAndClassPath)){
            for (String path:srcAndClassPath){
                File classeFile = new File(path,"target/classes");
                File srcFile = new File(path,"src/main/java");
                if (classeFile.exists() && srcFile.exists()){
                    if ("false".equals(branch)) {
                        coverageBuilder = new CoverageBuilder(gitPath, current, base);
                    } else {
                        coverageBuilder = new CoverageBuilder(gitPath, branch, current, base);
                    }
                    Analyzer analyzer = new Analyzer(this.execFileLoader.getExecutionDataStore(), coverageBuilder);
                    analyzer.analyzeAll(classeFile);
                    coverageSourceDirMap.put(coverageBuilder.getBundle(path.substring(11)),srcFile);
                }
            }
        }
    }

    private void getModulSrc(String path,List modulPath){
        File file = new File(path);
        if (file.isDirectory()){
            File[]files = file.listFiles();
            for (File f:files){
                if (f.isDirectory() && f.getName().equals("src")){
                    modulPath.add(path);
                }else {
                    getModulSrc(f.getPath(),modulPath);
                }
            }
        }
    }
}
