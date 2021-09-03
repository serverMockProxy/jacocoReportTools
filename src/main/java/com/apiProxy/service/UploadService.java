package com.apiProxy.service;

import com.apiProxy.exception.ServerException;
import com.apiProxy.model.FileType;
import com.apiProxy.model.UploadFile;
import com.apiProxy.utils.HttpServletUtil;
import com.apiProxy.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@Service
@Slf4j
public class UploadService {

    @Value("${static-location}/")
    private String staticLocation;
    public UploadFile upload(MultipartFile file, Integer fileType,String projectName) {
        if (file == null || fileType == null || StringUtils.isEmpty(projectName)) {
            throw new ServerException("file or fileType or projectName不能为空");
        }

        String uploadFilePath;
        switch (fileType) {
            case FileType.IMG:
                uploadFilePath = UploadFile.IMG_PATH;
                break;
            case FileType.EXEC:
                uploadFilePath = UploadFile.EXEC_PATH;
                break;
            default:
                throw new ServerException("不支持的文件类型");
        }

        String originalFilename = file.getOriginalFilename();
        String destFilename = UUIDUtil.getUUIDFilename(originalFilename);
        String destFilePath = uploadFilePath + "/" + projectName + "/" + destFilename;

        File uploadProjectExecFileDir = new File(staticLocation+uploadFilePath + "/" + projectName);
        if (!uploadProjectExecFileDir.exists()) {
            uploadProjectExecFileDir.mkdirs();
        }
        File execReadPath = new File(uploadProjectExecFileDir.getPath()+"/"+"ready");
        if (!execReadPath.exists()){
            execReadPath.mkdirs();
        }
        try {
            String destFileAbsolutePath = new File(staticLocation + destFilePath).getAbsolutePath();
            log.info("upload fileType: {}, {} -> {}", fileType, originalFilename, destFileAbsolutePath);
            file.transferTo(new File(destFileAbsolutePath));
        } catch (IOException e) {
            log.error("transfer err", e);
            throw new ServerException(e.getMessage());
        }

        UploadFile uploadFile = new UploadFile();
        uploadFile.setFilePath(destFilePath);
        uploadFile.setDownloadUrl(HttpServletUtil.getStaticResourceUrl(destFilePath));

        return uploadFile;
    }
}
