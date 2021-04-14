package com.security.todo.service;

import com.security.todo.model.Todo;
import com.security.todo.model.UserInfo;
import com.security.todo.model.request.TodoReq;
import com.security.todo.model.response.TodoResp;
import com.security.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public void addTodo(UserInfo userInfo, String content) {
        Todo todo = Todo.builder()
                .content(content)
                .writer(userInfo.getUsername())
                .build();
        todoRepository.save(todo);
    }

    @Transactional(readOnly = true)
    public Todo getTodo(Long pkey) {
        return todoRepository.findById(pkey).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public List<TodoResp> getTodos() {
        return todoRepository.findAll().stream()
                .map(x -> TodoResp.makeData(x))
                .collect(Collectors.toList());
    }

    public void updateTodo(TodoReq todoReq) {
        Todo todo = TodoReq.makeDomain(todoReq);
        todoRepository.save(todo);
    }

    @Override
    public void completeTodo(TodoReq todoReq) {
        todoReq.setComplete(true);
        Todo todo = TodoReq.makeDomain(todoReq);
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long pkey) {
        todoRepository.deleteById(pkey);
    }
}
