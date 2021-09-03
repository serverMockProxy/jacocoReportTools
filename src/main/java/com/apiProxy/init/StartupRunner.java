package com.apiProxy.init;

import com.apiProxy.model.UploadFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@Component
@Slf4j
public class StartupRunner implements ApplicationRunner {

    @Value("${static-location}/")
    private String staticLocation;

    @Override
    public void run(ApplicationArguments args) throws IOException {
        String uploadImgPath = staticLocation + UploadFile.IMG_PATH;
        String uploadExecPath = staticLocation + UploadFile.EXEC_PATH;
        File uploadImgDir = new File(uploadImgPath);
        if (!uploadImgDir.exists()) {
            log.info("创建img上传存放目录 -> {}", uploadImgPath);
            uploadImgDir.mkdirs();
        }
        File uploadExecFileDir = new File(uploadExecPath);
        if (!uploadExecFileDir.exists()) {
            log.info("创建exec file上传存放目录 -> {}", uploadExecPath);
            uploadExecFileDir.mkdirs();
        }

        File gitProjectFileDir = new File(UploadFile.GIT_PROJECT_PATH);
        if (!gitProjectFileDir.exists()){
            log.info("创建gitProject存放目录 -> {}", gitProjectFileDir);
            gitProjectFileDir.mkdirs();
        }
    }
}
