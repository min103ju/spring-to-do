package com.security.todo.service;

import com.security.todo.model.Todo;
import com.security.todo.model.UserInfo;
import com.security.todo.model.request.TodoReq;
import com.security.todo.model.response.TodoResp;

import java.util.List;

public interface TodoService {

    public void addTodo(UserInfo userInfo, String content);

    public Todo getTodo(Long pkey);

    public List<TodoResp> getTodos();

    public void updateTodo(TodoReq todo);

    public void completeTodo(TodoReq todo);

    public void deleteTodo(Long pkey);


}
