package com.security.todo.service;

import com.security.todo.model.domain.Todo;
import com.security.todo.model.UserInfo;
import com.security.todo.model.dto.TodoDto;

import java.util.List;

public interface TodoService {

    public TodoDto addTodo(UserInfo userInfo, TodoDto todoDto);

    public Todo getTodo(Long pkey);

    public List<TodoDto> getTodos();

    public void completeTodo(Long pkey);

    public void deleteTodo(Long pkey);


}
