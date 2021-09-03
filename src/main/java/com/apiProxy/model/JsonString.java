package com.apiProxy.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author：hem
 * @Date：1/15/21 5:37 下午
 */
@Data
public class JsonString {
    @NotNull(message = "json不能为空")
    private String jsonString;
}
