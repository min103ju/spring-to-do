package com.security.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/todoList")
    public String todoList() {
        return "redirection:/todoList";
    }
}
