package com.apiProxy.mbg.po;

import com.apiProxy.validator.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class Project implements Serializable {
    /**
     * 项目id
     *
     * @mbg.generated
     */
    @NotNull(message = "id不能为空", groups = {UpdateGroup.class})
    private Integer id;

    /**
     * 项目名
     *
     * @mbg.generated
     */
    @NotBlank(message = "项目名不能为空")
    private String name;

    /**
     * 项目名
     *
     * @mbg.generated
     */
    @NotBlank(message = "路径标记不能为空")
    private String defaultForwardHost;

    private Byte platform;
    /**
     * 项目描述
     *
     * @mbg.generated
     */
    private String description;

    private Integer creatorUid;

    private Date createTime;

    private String capabilities;

    private static final long serialVersionUID = 1L;

}