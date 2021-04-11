package com.security.todo.service;

import com.security.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoService {

    public void addTodo(Todo todo);

    public Todo getTodo(Long pkey);

    public List<Todo> getTodos();

    public void updateTodo(Todo todo);

    public void updateComplete(Todo todo);

    public void deleteTodo(Long pkey);


}
