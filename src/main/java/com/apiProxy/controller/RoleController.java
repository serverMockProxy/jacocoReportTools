package com.apiProxy.controller;

import com.apiProxy.mbg.po.Role;
import com.apiProxy.model.Response;
import com.apiProxy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public Response list() {
        List<Role> roles = roleService.list();
        return Response.success(roles);
    }
}
