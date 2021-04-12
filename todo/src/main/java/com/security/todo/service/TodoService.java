package com.security.todo.service;

import com.security.todo.model.Todo;
import com.security.todo.model.UserInfo;

import java.util.List;

public interface TodoService {

    public void addTodo(UserInfo userInfo, String content);

    public Todo getTodo(Long pkey);

    public List<Todo> getTodos();

    public void updateTodo(Todo todo);

    public void updateComplete(Todo todo);

    public void deleteTodo(Long pkey);


}
