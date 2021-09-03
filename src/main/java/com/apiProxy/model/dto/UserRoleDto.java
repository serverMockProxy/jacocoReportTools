package com.apiProxy.model.dto;

import com.apiProxy.mbg.po.Role;
import com.apiProxy.mbg.po.UserRole;
import lombok.Data;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@Data
public class UserRoleDto extends UserRole {
    private Role role;
}
