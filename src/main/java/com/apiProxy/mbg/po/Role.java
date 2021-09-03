package com.apiProxy.mbg.po;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
@Data
public class Role implements Serializable {
    private Integer id;

    /**
     * 角色名
     *
     * @mbg.generated
     */
    @NotBlank(message = "角色名不能为空")
    private String name;

    /**
     * 别名
     *
     * @mbg.generated
     */
    @NotBlank(message = "别名不能为空")
    private String alias;

    private static final long serialVersionUID = 1L;

}