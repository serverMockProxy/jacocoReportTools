package com.apiProxy.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.apiProxy.exception.ServerException;
import com.apiProxy.mbg.mapper.ProjectMapper;
import com.apiProxy.mbg.mapper.ProxyConfigMapper;
import com.apiProxy.mbg.po.*;
import com.apiProxy.model.dto.RequestInfo;
import com.apiProxy.utils.ApiCallback;
import com.apiProxy.utils.HttpRequest;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：hem
 * @Date：5/31/21 10:13 上午
 */
@Service
@Slf4j
public class MockServer {
    @Autowired
    private ProxyConfigServer proxyConfigServer;

    @Autowired
    private ProxyDetailServer proxyDetailServer;

    @Autowired
    private ProjectService projectService;

    public Object proxy(HttpServletRequest httpServletRequest){
        String[] urlInfo = httpServletRequest.getRequestURI().split("/proxy");
        if (StringUtils.isEmpty(urlInfo[0])){
            throw new ServerException("服务端代理设置错误");
        }
        String projectName = urlInfo[0].substring(1);
        String requestPath = urlInfo[1];
        ProxyConfig config = getConfigByInterceptPath(projectName,requestPath);
        ProxyDetails proxyDetails = new ProxyDetails();

        proxyDetails.setInterceptPath(requestPath);

        if (config == null){
            proxyDetails.setResponseJson("未找到此项目，".concat(projectName));
            proxyDetailServer.add(proxyDetails);
            throw new ServerException("未找到此项目，".concat(projectName));
        }
        proxyDetails.setProjectId(config.getProjectId());

        RequestInfo requestInfo = getOriginalRequest(httpServletRequest);
        requestInfo.setUrl(config.getForwardHost().concat(requestPath));
        proxyDetails.setRequestJson(requestInfo.getJsonString());
        proxyDetails.setMockRequir(config.getMockRequir());
        if (isMock(config.getMockRequir(),requestInfo)){
            try {
                log.info("请求参数：{}{}{}",requestInfo.getJsonString(),requestInfo.getQueryBody(),requestInfo.getFormBody());
                log.info("mock返回值{}",config.getMockResponse());
                JSONObject jsonObject = JSONObject.parseObject(config.getMockResponse());
                proxyDetails.setResponseJson(jsonObject.toJSONString());
                if(config.getIsCallback()){
                    new Thread(()->{
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ApiCallback apiCallback = new ApiCallback(config,requestInfo);
                        ApiCallback callback = apiCallback.doinvok();
                        proxyDetails.setCallbackUrl(callback.getCallbackRequestInfo().getUrl());
                        proxyDetails.setCallbackMethod(callback.getCallbackRequestInfo().getRequestType());
                        proxyDetails.setCallbackRequestJson(callback.getCallbackRequestInfo().getJsonString());
                        proxyDetails.setCallbackResponseJson(callback.getResponse().getBody().asString());
                        proxyDetailServer.add(proxyDetails);
                    }).start();
                }else {
                    proxyDetailServer.add(proxyDetails);
                }
                return jsonObject;
            }catch (Exception e){
                throw new ServerException("mock返回参数只支持json格式");
            }
        }


        HttpRequest httpRequest = new HttpRequest();
        Response response = httpRequest.doRequst(requestInfo);
        proxyDetails.setResponseJson(response.getBody().asString());
        proxyDetails.setForwardHost(config.getForwardHost());
        new Thread(()->{
            proxyDetailServer.add(proxyDetails);
        }).start();

        try {
            JSONObject jsonObject = response.getBody().as(JSONObject.class);
            log.info("转发接口返回"+response.getBody().asString());
            return jsonObject;
        }catch (Exception e){
            try {
                JSONArray jsonArray = response.getBody().as(JSONArray.class);
                return jsonArray;
            }catch (Exception e1){
                throw new ServerException("服务端返回的为非json"+response.getBody().asString());
            }
        }
    }


    /**
     * 获取原始请求头
     * @param httpServletRequest
     * @return
     */
    public HashMap getHeaders(HttpServletRequest httpServletRequest){
        Enumeration headerNames = httpServletRequest.getHeaderNames();
        HashMap map = new HashMap();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            if (key.toLowerCase().equals("content-length") || key.toLowerCase().equals("host")){
                continue;
            }
            String value = httpServletRequest.getHeader(key);
            map.put(key, value);
        }
        if (!map.isEmpty()){
            return map;
        }
        return null;
    }

    /**
     * 获取原始请求参数
     * @param httpServletRequest
     */
    public RequestInfo getOriginalRequest(HttpServletRequest httpServletRequest){
        RequestInfo requestInfo = new RequestInfo();
        String method = httpServletRequest.getMethod();
        requestInfo.setRequestType(method);
        requestInfo.setRequestHeaders(getHeaders(httpServletRequest));

        String query = httpServletRequest.getQueryString();
        Map queryMap = QueryToMap(query);
        requestInfo.setQueryBody(queryMap);

        Map<String, String> orgParametMap = new HashMap<>();
        httpServletRequest.getParameterMap().forEach((k,v)->{
            if (!queryMap.containsKey(k)){
                orgParametMap.put(k,v[1]);
            }
        });
        requestInfo.setFormBody(orgParametMap);

        try {
            BufferedReader streamReader = new BufferedReader( new InputStreamReader(httpServletRequest.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null){
                responseStrBuilder.append(inputStr);
            }
            String body = responseStrBuilder.toString();
            if (!body.isEmpty()){
                requestInfo.setJsonString(body);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return requestInfo;
    }

    public Map<String, String> QueryToMap(String queryString){
        if (!StringUtils.isEmpty(queryString)){
            Map queryMap = new HashMap();
            String[] querys = queryString.split("&");
            for (String query:querys){
               String[] value = query.split("=");
               queryMap.put(value[0],value[1]);
            }
            return queryMap;
        }
        return null;
    }

    private boolean isMock(String mockRequir,RequestInfo requestInfo){
        boolean mock = false;
        if (StringUtils.isEmpty(mockRequir)){
            return mock;
        }
        if (!StringUtils.isEmpty(requestInfo.getJsonString()) && requestInfo.getJsonString().contains(mockRequir)){
            mock = true;
        }
        if (requestInfo.getQueryBody() != null && (requestInfo.getQueryBody().containsValue(mockRequir) || requestInfo.getQueryBody().containsValue(mockRequir))){
            mock = true;
        }

        if (requestInfo.getFormBody() != null && (requestInfo.getFormBody().containsValue(mockRequir) || requestInfo.getFormBody().containsValue(mockRequir))){
            mock = true;
        }
        return mock;
    }

    /**
     * 获取路径配置信息
     * @param requestPath
     * @return
     */
    public ProxyConfig getConfigByInterceptPath(String projectName,String requestPath){
        Project query = new Project();
        query.setName(projectName);
        List<Project> projects = projectService.getProjects(query,null);
        if (CollectionUtils.isEmpty(projects)){
            return null;
        }
        Project project = projects.get(0);

        ProxyConfig proxyConfig = new ProxyConfig();
        proxyConfig.setInterceptPath(requestPath);
        proxyConfig.setProjectId(project.getId());
        List<ProxyConfig> configs = proxyConfigServer.getProxyConfig(proxyConfig,null);

        if (!CollectionUtils.isEmpty(configs)){
            return configs.get(0);
        }else {
            proxyConfig.setForwardHost(project.getDefaultForwardHost());
            proxyConfig.setIsCallback(false);
            return proxyConfig;
        }
    }
}
