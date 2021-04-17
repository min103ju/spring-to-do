package com.security.todo.controller;

import com.security.todo.model.domain.Todo;
import com.security.todo.model.UserInfo;
import com.security.todo.model.dto.TodoDto;
import com.security.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;


    @PostMapping("/todo")
    public ResponseEntity addTodo(@RequestBody TodoDto todoDto, @AuthenticationPrincipal UserInfo userInfo) {
        return new ResponseEntity(todoService.addTodo(userInfo, todoDto), HttpStatus.CREATED);
    }

    @GetMapping("/todo")
    public ResponseEntity<Todo> getTodo(Long pkey) {
        return new ResponseEntity(todoService.getTodo(pkey), HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TodoDto>> getTodos() {
        return new ResponseEntity(todoService.getTodos(), HttpStatus.OK);
    }

    @PatchMapping("/complete")
    public ResponseEntity completeTodo(TodoDto todoDto) {
        todoService.completeTodo(todoDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/todo")
    public ResponseEntity deleteTodo(Long pkey) {
        todoService.deleteTodo(pkey);
        return new ResponseEntity(HttpStatus.OK);
    }

}
