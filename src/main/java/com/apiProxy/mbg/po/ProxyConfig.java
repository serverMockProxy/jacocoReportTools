package com.apiProxy.mbg.po;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
public class ProxyConfig {
    private Integer id;

    private Integer projectId;

    private String description;
    @NotBlank(message = "拦截路径不能为空")
    private String interceptPath;
    @NotBlank(message = "转发host不能为空")
    private String forwardHost;

    private String mockRequir;

    private String mockResponse;

    private Boolean isCallback;

    private String callbackHost;

    private String callbackPath;

    private String callbackMethod;

    private Integer signType;

    private String clientSecret;

    private String clientId;

    private String callbackBodyType;

    private List callbackHeaders;

    private List callbackRequestJson;

    private List callbackRequestQuery;

    private List callbackRequestForm;

    private Date createTime;

    private Date updateTime;

    private Integer creatorUid;

    private Boolean status;

}