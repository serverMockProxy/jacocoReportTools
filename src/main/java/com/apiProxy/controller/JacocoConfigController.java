package com.apiProxy.controller;

import com.apiProxy.mbg.po.JacocoConfig;
import com.apiProxy.model.Response;
import com.apiProxy.service.JacocoConfigServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author：hem
 * @Date：6/24/21 4:28 下午
 */
@RestController
@RequestMapping("/jacocoConfig")
public class JacocoConfigController {
    public static String url;
    @Autowired
    private JacocoConfigServer jacocoConfigServer;

    @PostMapping("/creatOrUpdate")
    public Response creatOrUpdate(@Valid @RequestBody JacocoConfig jacocoConfig) {
        jacocoConfigServer.creatOrUpdate(jacocoConfig);
        return Response.success("配置成功");
    }

    @GetMapping("/getConfig/{projectId}")
    public Response getJacocoConfig(@PathVariable Integer projectId){
        return Response.success(jacocoConfigServer.getJacocoConfig(projectId));
    }
}
