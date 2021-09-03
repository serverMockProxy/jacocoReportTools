package com.apiProxy.service;

import com.apiProxy.mbg.mapper.RoleMapper;
import com.apiProxy.mbg.po.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> list() {
        return roleMapper.selectByExample(null);
    }

}
