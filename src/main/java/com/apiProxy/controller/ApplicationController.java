package com.apiProxy.controller;

import com.apiProxy.model.Response;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Value("${version}")
    private String version;

    @GetMapping("/version")
    public Response version() {
        return Response.success(ImmutableMap.of("version", version));
    }

}
