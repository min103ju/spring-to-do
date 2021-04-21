package com.security.todo.controller;

import com.security.todo.exception.CustomUserException;
import com.security.todo.model.UserInfoDto;
import com.security.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public String signup(UserInfoDto userInfoDto) throws CustomUserException {
        userService.save(userInfoDto);
        return "redirect:/";
    }
}
