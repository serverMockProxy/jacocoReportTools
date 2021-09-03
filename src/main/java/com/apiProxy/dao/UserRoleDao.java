package com.apiProxy.dao;

import com.apiProxy.mbg.po.UserRole;
import com.apiProxy.model.dto.UserRoleDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
public interface UserRoleDao {
    int insertBatch(@Param("userRoles") List<UserRole> userRoles);

    List<UserRoleDto> selectUserRoleDtosByUserIds(@Param("userIds") List<Integer> userIds);
}
