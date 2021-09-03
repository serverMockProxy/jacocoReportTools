package com.apiProxy.utils;

import com.apiProxy.exception.ServerException;
import com.apiProxy.model.UploadFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：hem
 * @Date：6/25/21 2:12 下午
 */
@Slf4j
public class GitLabUtil {

    public static Gitlab builder(){
        try {
            String gitVersion = Terminal.execute("git --version");
            if (!gitVersion.contains("version")){
                throw  new ServerException("服务器未安装git命令");
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return new Gitlab();
    }
    public static class Gitlab{
        private static String gitUrl;


        public Gitlab(){
        }

        public void setGitUrl(String url){
            this.gitUrl = url;
        };
        public void gitClone(String clonePath){
            if (StringUtils.isEmpty(clonePath)){
                return;
            }
            try {
                Terminal.execute("git clone "+gitUrl+clonePath,new File(UploadFile.GIT_PROJECT_PATH));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void gitCheckoutBranch(String branch,String gitProjectName){
            if (StringUtils.isEmpty(branch) || StringUtils.isEmpty(gitProjectName)){
                return;
            }
            try {
                File file = new File(UploadFile.GIT_PROJECT_PATH+File.separatorChar+gitProjectName);
                Terminal.execute("git checkout "+branch,file);
                Terminal.execute("git pull",file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void gitCheckoutCommit(String commitId,String gitProjectName){
            if (StringUtils.isEmpty(commitId) || StringUtils.isEmpty(gitProjectName)){
                return;
            }
            try {
                File file = new File(UploadFile.GIT_PROJECT_PATH+File.separatorChar+gitProjectName);
                Terminal.execute("git checkout "+commitId,file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
