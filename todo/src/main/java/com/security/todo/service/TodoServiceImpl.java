package com.security.todo.service;

import com.security.todo.model.domain.Todo;
import com.security.todo.model.UserInfo;
import com.security.todo.model.dto.TodoDto;
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
    public List<TodoDto> getTodos() {
        return todoRepository.findAll().stream()
                .map(x -> x.todoDto())
                .collect(Collectors.toList());
    }

    public void updateTodo(TodoDto todoDto) {
        todoRepository.save(todoDto.toEntity());
    }

    @Override
    public void completeTodo(TodoDto todoDto) {
        todoDto.setComplete(true);
        todoRepository.save(todoDto.toEntity());
    }

    @Override
    public void deleteTodo(Long pkey) {
        todoRepository.deleteById(pkey);
    }
}
