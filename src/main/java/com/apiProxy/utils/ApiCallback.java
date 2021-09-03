package com.apiProxy.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.apiProxy.mbg.po.ProxyConfig;
import com.apiProxy.model.dto.RequestInfo;
import com.apiProxy.utils.sign.MD5;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：hem
 * @Date：6/4/21 3:58 下午
 */
@Slf4j
public class ApiCallback {

    private ProxyConfig proxyConfig;
    private RequestInfo requestInfo;
    private Map<String, Object> var = new HashMap<>();

    public Response getResponse() {
        return response;
    }

    public RequestInfo getCallbackRequestInfo() {
        return callbackRequestInfo;
    }

    private Response response;
    private RequestInfo callbackRequestInfo;
    public ApiCallback(ProxyConfig proxyConfig, RequestInfo requestInfo){
        this.proxyConfig = proxyConfig;
        this.requestInfo = requestInfo;
        setVar();
    }
    public ApiCallback doinvok(){
        Transform transform = new Transform(var);
        callbackRequestInfo = new RequestInfo();
        callbackRequestInfo.setUrl(proxyConfig.getCallbackHost()+proxyConfig.getCallbackPath());
        callbackRequestInfo.setRequestType(proxyConfig.getCallbackMethod());
        callbackRequestInfo.setRequestHeaders(transform.transformHeaders(proxyConfig.getCallbackHeaders()));
        callbackRequestInfo.setJsonString(null);
        callbackRequestInfo.setJsonString(transform.transformToJsonString(JSONArray.toJSONString(proxyConfig.getCallbackRequestJson())));
        callbackRequestInfo.setQueryBody(transform.transformToQueryMap(proxyConfig.getCallbackRequestQuery()));
        callbackRequestInfo.setFormBody(transform.transformToQueryMap(proxyConfig.getCallbackRequestForm()));
        if (proxyConfig.getSignType() == 2){
            signBody(callbackRequestInfo);
        }
        HttpRequest httpRequest = new HttpRequest();
        response = httpRequest.doRequst(callbackRequestInfo);
        log.info("回调接口返回"+response.getBody().asString());
        return this;
    }

    private void signBody(RequestInfo requestInfo){
        if (StringUtils.isEmpty(requestInfo.getJsonString())){
            return;
        }
        try {
            JSONObject jsonObject = JSONObject.parseObject(requestInfo.getJsonString());
            long timestamp = new Date().getTime();
            String paramsMd5 = MD5.MD5Lower32(jsonObject.getString("params"));
            String tmpString = jsonObject.get("clientId") + proxyConfig.getClientSecret() + timestamp + paramsMd5;
            jsonObject.put("timestamp",timestamp);
            jsonObject.put("sign",MD5.MD5Lower32(tmpString));
            requestInfo.setJsonString(jsonObject.toJSONString());
        }catch (Exception e){

        }
    }

    private void setVar(){
        if (null != requestInfo.getFormBody()){
            var.putAll(requestInfo.getFormBody());
        }
        if (null != requestInfo.getQueryBody()){
            var.putAll(requestInfo.getQueryBody());
        }
        if (!StringUtils.isEmpty(requestInfo.getJsonString())){
            jsonObjectRecursion(requestInfo.getJsonString());
        }
    }


    private boolean jsonObjectRecursion(String a){
        boolean s = true;
        try {
            JSONObject jsonObject = JSONObject.parseObject(a);
            for (String key:jsonObject.keySet()){
                if (jsonObject.get(key) instanceof String || jsonObject.get(key) instanceof JSONObject || jsonObject.get(key) instanceof JSONArray){
                    if (jsonObjectRecursion(jsonObject.getString(key))){
                        var.put(key,jsonObject.get(key));
                    }
                }else {
                    var.put(key,jsonObject.get(key));
                }
            }
            s = false;
        }catch (Exception e){
            try {
                JSONArray jsonArray = JSONArray.parseArray(a);
                jsonObjectRecursion(jsonArray.getJSONObject(0).toJSONString());
                s = false;
            }catch (Exception e1){

            }

        }
        return s;
    }


}
