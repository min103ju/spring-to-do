package com.security.todo.service;

import com.security.todo.utils.SecurityUtil;
import com.security.todo.model.domain.Todo;
import com.security.todo.model.UserInfo;
import com.security.todo.model.dto.TodoDto;
import com.security.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public TodoDto addTodo(UserInfo userInfo, TodoDto todoDto) {
        Todo todo = Todo.builder()
                .content(todoDto.getContent())
                .writer(userInfo.getUsername())
                .build();
        return todoRepository.save(todo).todoDto();
    }

    @Transactional(readOnly = true)
    @Override
    public Todo getTodo(Long pkey) {
        return todoRepository.findById(pkey).orElseThrow(() -> new NoSuchElementException());
    }

    @Transactional(readOnly = true)
    @Override
    public List<TodoDto> getTodos() {

        UserInfo currentUser = SecurityUtil.getCurrentUser();
        Sort sort = Sort.by(Sort.Direction.DESC, "pkey").and(Sort.by(Sort.Direction.ASC, "complete"));
        return todoRepository.findAllByWriter(currentUser.getEmail(), sort).stream()
                .map(x -> x.todoDto())
                .collect(Collectors.toList());
    }

    @Override
    public void completeTodo(Long pkey) {
        Todo todo = todoRepository.findById(pkey)
                .map(x -> {
                    return x.builder()
                            .pkey(x.getPkey())
                            .content(x.getContent())
                            .writer(x.getWriter())
                            .complete(true)
                            .createDate(x.getCreateDate())
                            .completeDate(Instant.now())
                            .build();
                }).orElseThrow(() -> new NoSuchElementException());
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long pkey) {
        todoRepository.deleteById(pkey);
    }
}
