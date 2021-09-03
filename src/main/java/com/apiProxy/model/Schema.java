package com.apiProxy.model;

import lombok.Data;

import java.util.List;

/**
 * @Author：hem
 * @Date：6/2/20 3:21 下午
 */
@Data
public class Schema {
    private String type;
    private String key;
    private String value;
    private String description;
    private List<Schema> children;
}
