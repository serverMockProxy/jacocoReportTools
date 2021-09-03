package com.apiProxy.mbg.po;

import java.util.Date;

public class ProxyDetails {
    private Integer id;

    private Integer projectId;

    private String interceptPath;

    private String forwardHost;

    private String mockRequir;

    private String requestJson;

    private String responseJson;

    private String callbackUrl;

    private String callbackMethod;

    private String callbackRequestJson;

    private String callbackResponseJson;

    private String description;

    private Date creatTime;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getInterceptPath() {
        return interceptPath;
    }

    public void setInterceptPath(String interceptPath) {
        this.interceptPath = interceptPath == null ? null : interceptPath.trim();
    }

    public String getForwardHost() {
        return forwardHost;
    }

    public void setForwardHost(String forwardHost) {
        this.forwardHost = forwardHost == null ? null : forwardHost.trim();
    }

    public String getMockRequir() {
        return mockRequir;
    }

    public void setMockRequir(String mockRequir) {
        this.mockRequir = mockRequir == null ? null : mockRequir.trim();
    }

    public String getRequestJson() {
        return requestJson;
    }

    public void setRequestJson(String requestJson) {
        this.requestJson = requestJson == null ? null : requestJson.trim();
    }

    public String getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(String responseJson) {
        this.responseJson = responseJson == null ? null : responseJson.trim();
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl == null ? null : callbackUrl.trim();
    }

    public String getCallbackMethod() {
        return callbackMethod;
    }

    public void setCallbackMethod(String callbackMethod) {
        this.callbackMethod = callbackMethod == null ? null : callbackMethod.trim();
    }

    public String getCallbackRequestJson() {
        return callbackRequestJson;
    }

    public void setCallbackRequestJson(String callbackRequestJson) {
        this.callbackRequestJson = callbackRequestJson == null ? null : callbackRequestJson.trim();
    }

    public String getCallbackResponseJson() {
        return callbackResponseJson;
    }

    public void setCallbackResponseJson(String callbackResponseJson) {
        this.callbackResponseJson = callbackResponseJson == null ? null : callbackResponseJson.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}