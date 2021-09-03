package com.apiProxy.security;

import com.apiProxy.model.dto.UserDto;
import com.apiProxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userService.getUserDtoByUsername(username);
        if (userDto == null) {
            throw new UsernameNotFoundException(username + " not found");
        }

        return userDto;
    }

}
