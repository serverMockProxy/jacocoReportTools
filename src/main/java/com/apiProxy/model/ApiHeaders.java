package com.apiProxy.model;

import lombok.Data;

/**
 * @Author：hem
 * @Date：10/25/20 4:35 下午
 */
@Data
public class ApiHeaders {

    /**
     * 请求头参数
     */
    private String headerKey;
    /**
     * 请求头值
     */
    private String headerValue;
    /**
     * 请求头描述
     */
    private String description;
}
