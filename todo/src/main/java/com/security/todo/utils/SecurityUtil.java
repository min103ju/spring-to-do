package com.security.todo.utils;

import com.security.todo.model.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static UserInfo getCurrentUser() {
        return (UserInfo) SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getPrincipal();
    }
}
