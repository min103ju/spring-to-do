package com.security.todo.controller;

import com.security.todo.exception.CustomUserException;
import com.security.todo.model.UserInfoDto;
import com.security.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ModelAndView index(@RequestParam(value = "error", required = false) Boolean error,
                              @RequestParam(value = "errorMsg", required = false) String errorMsg,
                              ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("error", error);
        modelAndView.addObject("errorMsg", errorMsg);
        return modelAndView;
    }

    @PostMapping("/signup")
    public String signup(UserInfoDto userInfoDto) throws CustomUserException {
        userService.save(userInfoDto);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/";
    }
}
