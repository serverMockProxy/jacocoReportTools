package com.apiProxy.model.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：hem
 * @Date：5/31/21 2:16 下午
 */
@Data
public class RequestInfo {
    private String url;
    private String requestType;
    private String jsonString;
    private Map queryBody;
    private String responseBody;
    private Map requestHeaders;
    private Map formBody;
}
