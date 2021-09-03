package com.apiProxy.mbg.po;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
@Data
public class JacocoConfig {
    @NotNull(message = "projectId不能为空")
    private Integer projectId;
    @NotNull(message = "gitId不能为空")
    private Integer gitId;

    private String description;

    private List<JacocoConfig> children;

}