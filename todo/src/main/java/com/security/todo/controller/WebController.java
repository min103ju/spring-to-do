package com.security.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @GetMapping("/")
    public ModelAndView index(@RequestParam(value = "error", required = false) Boolean error,
                              @RequestParam(value = "errorMsg", required = false) String errorMsg,
                              ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("error", error);
        modelAndView.addObject("errorMsg", errorMsg);
        return modelAndView;
    }

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping("/todoList")
    public String todoList() {
        return "todoList";
    }

}
