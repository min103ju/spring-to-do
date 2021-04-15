package com.security.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping("/todoList")
    public String todoList() {
        return "todoList";
    }

//    @RequestMapping("/error")
//    public String error() {
//        return "error";
//    }

}
