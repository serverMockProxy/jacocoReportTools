package com.apiProxy.model;

import lombok.Data;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@Data
public class UploadFile {

    public static final String UPLOAD_FILE_PATH = "upload";

    public static final String IMG_PATH = UPLOAD_FILE_PATH + "/img";

    public static final String EXEC_PATH = UPLOAD_FILE_PATH + "/exec";

    public static final String GIT_PROJECT_PATH ="gitProject";

    private String filePath;
    private String downloadUrl;
}
