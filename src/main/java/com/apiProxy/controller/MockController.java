package com.apiProxy.controller;

import com.apiProxy.service.MockServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author：hem
 * @Date：5/28/21 11:07 上午
 */
@RestController
public class MockController {

    @Autowired
    private MockServer mockServer;
    @ResponseBody
    @RequestMapping(value = "/**/proxy/**", method = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
    public Object proxy(HttpServletRequest httpServletRequest){
       return mockServer.proxy(httpServletRequest);
    }
}
