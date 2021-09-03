package com.apiProxy.security;

import com.apiProxy.model.dto.UserDto;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
public class SecurityUtil {

    public static Integer getCurrentUserId() {
        return getCurrentUserDto().getId();
    }

    public static UserDto getCurrentUserDto() {
        return (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
