package com.apiProxy.utils;

import lombok.extern.slf4j.Slf4j;
import org.jacoco.core.tools.ExecFileLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author：hem
 * @Date：6/25/21 5:32 下午
 */
@Slf4j
public class JacocoMergeDump {

    private final String path;
    private final File destFile;

    public JacocoMergeDump(String path) {
        this.path = path;
        this.destFile = new File(path + "/jacoco.exec");
    }

    private List<File> fileSets(String dir) {
        List<File> fileSetList = new ArrayList();
        File path = new File(dir);
        if (!path.exists()) {
            log.info("未找到路径:{}",dir);
            return null;
        } else {
            File[] files = path.listFiles();

            try {
                if (files == null || files.length == 0) {
                    return null;
                }
            } catch (NullPointerException var9) {
                var9.printStackTrace();
            }

            File[] var5 = files;
            int var6 = files.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                File file = var5[var7];
                if (file.getName().contains(".exec")) {
                    fileSetList.add(file);
                } else {
                    log.info("非exec文件:" + file.getAbsolutePath());
                }
            }

            return fileSetList;
        }
    }

    public void executeMerge() throws Exception {
        ExecFileLoader loader = new ExecFileLoader();
        this.load(loader);
        this.save(loader);
        Iterator var2 = this.fileSets(this.path).iterator();

        while(var2.hasNext()) {
            File fileSet = (File)var2.next();
            if (!fileSet.getName().equals("jacoco.exec")) {
                fileSet.delete();
            }
        }

    }

    public void load(ExecFileLoader loader) throws Exception {
        Iterator var2 = this.fileSets(this.path).iterator();

        while(var2.hasNext()) {
            File fileSet = (File)var2.next();
            File inputFile = new File(this.path, fileSet.getName());
            if (!inputFile.isDirectory()) {
                try {
                    loader.load(inputFile);
                } catch (IOException var6) {
                    throw new Exception("Unable to read " + inputFile.getAbsolutePath(), var6);
                }
            }
        }

    }

    public void save(ExecFileLoader loader) throws Exception {
        if (loader.getExecutionDataStore().getContents().isEmpty()) {
            log.error("Skipping JaCoCo merge execution due to missing execution data files");
        } else {
            log.info("Writing merged execution data to " + this.destFile.getAbsolutePath());
            try {
                loader.save(this.destFile, false);
            } catch (IOException var3) {
                throw new Exception("Unable to write merged file " + this.destFile.getAbsolutePath(), var3);
            }
        }
    }
}
