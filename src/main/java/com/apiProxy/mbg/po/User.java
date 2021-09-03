package com.apiProxy.mbg.po;

import com.apiProxy.validator.SaveUserGroup;
import com.apiProxy.validator.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
@Data
public class User implements Serializable {

    public static final int ENABLE_STATUS = 1;

    @NotNull(message = "用户id不能为空", groups = {UpdateGroup.class})
    private Integer id;

    /**
     * 用户名
     *
     * @mbg.generated
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 用户密码
     *
     * @mbg.generated
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 用户昵称
     *
     * @mbg.generated
     */
    @NotBlank(message = "昵称不能为空", groups = {SaveUserGroup.class})
    private String nickName;

    /**
     * 状态，0:禁用 1:正常
     *
     * @mbg.generated
     */
    @NotNull(message = "账户状态不能为空", groups = {SaveUserGroup.class})
    private Integer status;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}