package com.apiProxy.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author：hem
 * @Date：8/19/21 5:26 下午
 */
@Data
public class ToolsDto  {
    @NotEmpty(message = "wid不能为空")
    private String wid;
}
