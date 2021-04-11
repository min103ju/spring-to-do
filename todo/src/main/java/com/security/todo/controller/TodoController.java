package com.security.todo.controller;

import com.security.todo.model.Todo;
import com.security.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;


    @PostMapping("/todo")
    public void addTodo(@RequestBody Todo todo) throws Exception {
        todoService.addTodo(todo);
    }

    @ResponseBody
    @GetMapping("/todo")
    public Todo getTodo(Long pkey) throws Exception {
        return todoService.getTodo(pkey);
    }

    @ResponseBody
    @GetMapping("/todos")
    public List<Todo> getTodos() throws Exception {
        return todoService.getTodos();
    }

    @PutMapping("/todo")
    public void updateTodo(Todo todo) throws Exception {
        todoService.updateTodo(todo);
    }

    @DeleteMapping("/todo")
    public void deleteTodo(Long pkey) throws Exception {
        todoService.deleteTodo(pkey);
    }
}
