package com.apiProxy.service;

import com.apiProxy.dao.UserRoleDao;
import com.apiProxy.exception.ServerException;
import com.apiProxy.mbg.mapper.UserRoleMapper;
import com.apiProxy.mbg.po.Role;
import com.apiProxy.mbg.po.UserRole;
import com.apiProxy.mbg.po.UserRoleExample;
import com.apiProxy.model.dto.UserRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@Service
public class UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private UserRoleMapper userRoleMapper;

    public void addBatch(List<UserRole> userRoles) {
        int insertCount = userRoleDao.insertBatch(userRoles);
        if (insertCount != userRoles.size()) {
            throw new ServerException("添加失败");
        }
    }

    public void addBatch(Integer userId, List<Role> roles) {

        List<UserRole> userRoles = roles.stream().map(role -> {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(role.getId());
            return userRole;
        }).collect(Collectors.toList());

        addBatch(userRoles);
    }

    public int deleteByUserId(Integer userId) {
        UserRoleExample example = new UserRoleExample();
        UserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return userRoleMapper.deleteByExample(example);
    }

    public List<UserRoleDto> getUserRoleDtosByUserIds(List<Integer> userIds) {
        if (CollectionUtils.isEmpty(userIds)) {
            return new ArrayList<>();
        }

        return userRoleDao.selectUserRoleDtosByUserIds(userIds);
    }
}
