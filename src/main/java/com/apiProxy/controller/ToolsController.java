package com.apiProxy.controller;

import com.alibaba.fastjson.JSONObject;
import com.apiProxy.model.Response;
import com.apiProxy.model.dto.ToolsDto;
import com.apiProxy.model.vo.GitlabBranchesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

/**
 * @Author：hem
 * @Date：8/19/21 5:21 下午
 */
@RestController
@RequestMapping("/tools")
public class ToolsController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${thrHost}/test/proxy/rasdf")
    private String demoPath;

    @PostMapping("/query")
    public Response query(@Valid @RequestBody ToolsDto toolsDto) {
        Object jsonObject = restTemplate.exchange(demoPath,
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<Object>() {
                },
                toolsDto).getBody();
        return Response.success(jsonObject);
    }
}
