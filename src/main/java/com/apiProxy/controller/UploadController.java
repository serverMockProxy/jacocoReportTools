package com.apiProxy.controller;

import com.apiProxy.model.Response;
import com.apiProxy.model.UploadFile;
import com.apiProxy.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@RestController
@RequestMapping("/upload")
@Slf4j
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/file/{projectName}/{fileType}")
    public Response uploadFile(MultipartFile file, @PathVariable Integer fileType,@PathVariable String projectName) {
        UploadFile uploadFile = uploadService.upload(file, fileType,projectName.toLowerCase());
        return Response.success(uploadFile);
    }
}
