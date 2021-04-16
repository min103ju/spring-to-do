package com.security.todo.controller;

import com.security.todo.model.UserInfo;
import com.security.todo.model.UserInfoDto;
import com.security.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

//    @PostMapping("/login")
//    public void login(String username, String password) {
//        UserInfo userInfo = userService.loadUserByUsername(username);
//        if(!passwordEncoder.matches(password ,userInfo.getPassword())) throw new IllegalArgumentException("비밀번호가 틀립니다.");
//    }

    @PostMapping("/signup")
    public String signup(UserInfoDto userInfoDto) {
        userService.save(userInfoDto);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/";
    }
}
