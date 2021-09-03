package com.apiProxy.controller;

import com.apiProxy.mbg.po.User;
import com.apiProxy.model.PageRequest;
import com.apiProxy.model.PagedData;
import com.apiProxy.model.Response;
import com.apiProxy.model.dto.UserDto;
import com.apiProxy.security.SecurityUtil;
import com.apiProxy.service.UserService;
import com.apiProxy.validator.SaveUserGroup;
import com.apiProxy.validator.UpdateGroup;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/add")
    public Response add(@Validated({SaveUserGroup.class}) @RequestBody UserDto userDto) {
        userService.add(userDto);
        return Response.success("添加成功");
    }

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{userId}")
    public Response delete(@PathVariable Integer userId) {
        userService.delete(userId);
        return Response.success("删除成功");
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/update")
    public Response update(@Validated({SaveUserGroup.class, UpdateGroup.class}) @RequestBody UserDto userDto) {
        userService.update(userDto);
        return Response.success("更新成功");
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/list")
    public Response list(User query, String orderBy, PageRequest pageRequest) {
        if (pageRequest.needPaging()) {
            PagedData<UserDto> pagedData = userService.list(query, orderBy, pageRequest);
            return Response.success(pagedData);
        } else {
            List<UserDto> userDtos = userService.getUserDtos(query, orderBy);
            return Response.success(userDtos);
        }
    }

    @PostMapping("/login")
    public Response login(@Valid @RequestBody User user) {
        String token = userService.login(user);
        return Response.success("登陆成功", ImmutableMap.of("token", token));
    }

    @GetMapping("/info")
    public Response getInfo() {
        return Response.success(SecurityUtil.getCurrentUserDto());
    }

    @PostMapping("/logout")
    public Response logout() {
        return Response.success();
    }

}
