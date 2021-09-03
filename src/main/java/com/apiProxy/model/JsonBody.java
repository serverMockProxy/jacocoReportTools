package com.apiProxy.model;

import lombok.Data;

import java.util.List;

/**
 * @Author：hem
 * @Date：10/25/20 4:37 下午
 */
@Data
public class JsonBody {

    private Integer num;
    private String type;
    private String value;
    private String key;
    private String description;
    private List children;
}
