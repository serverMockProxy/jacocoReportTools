package com.apiProxy.model.dto;

import com.apiProxy.mbg.po.Project;
import com.apiProxy.mbg.po.Role;
import com.apiProxy.mbg.po.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@Data
public class UserDto extends User implements UserDetails {

    @NotEmpty(message = "角色不能为空")
    private List<Role> roles;

    @NotNull(message = "projects不能为null")
    private List<Project> projects;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return getStatus() == User.ENABLE_STATUS;
    }
}
