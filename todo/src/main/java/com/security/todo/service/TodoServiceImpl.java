package com.security.todo.service;

import com.security.todo.model.Todo;
import com.security.todo.model.UserInfo;
import com.security.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public void addTodo(UserInfo userInfo, String content) {
        Todo todo = new Todo(null, content, userInfo.getUsername(), false, Instant.now(), null);
        todoRepository.save(todo);
    }

    @Transactional(readOnly = true)
    public Todo getTodo(Long pkey) {
        return todoRepository.findById(pkey).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void updateComplete(Todo todo) {
        if(!todo.isComplete()) {
            todo.setComplete(true);
            todoRepository.save(todo);
        }
    }

    @Override
    public void deleteTodo(Long pkey) {
        todoRepository.deleteById(pkey);
    }
}
