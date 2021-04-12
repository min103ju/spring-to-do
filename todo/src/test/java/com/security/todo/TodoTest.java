package com.security.todo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.todo.controller.TodoController;
import com.security.todo.model.Todo;
import com.security.todo.repository.TodoRepository;
import com.security.todo.service.TodoService;
import com.security.todo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoController.class)
@AutoConfigureMockMvc
public class TodoTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private UserService userService;

    @MockBean
    private TodoService todoService;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilter(new CharacterEncodingFilter("UTF-8"))
                .alwaysDo(print()).build();
    }

    @Test
    void addTodo() throws Exception {
        mockMvc.perform(post("/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("Content Add Todo"))
                .andExpect(status().isOk());
    }

    @Test
    void getTodo() throws Exception {
        long idx = 1L;
        HashMap<Object, Object> param = new HashMap<>();

        mockMvc.perform(get("/todo")
                .param("pkey", String.valueOf(idx)))
                .andExpect(status().isOk());
    }

    @Test
    void getTodos() throws Exception {

        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk());
    }

    @Test
    void updateTodo() throws Exception {
        long idx = 1L;
        Todo todo = new Todo(idx, "Update Todo" + idx, "admin",false, Instant.now(), null);

        mockMvc.perform(put("/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(todo)))
                .andExpect(status().isOk());
    }

    @Test
    void deleteTodo() throws Exception {
        long idx = 1L;

        mockMvc.perform(delete("/todo")
                .param("pkey", String.valueOf(idx)))
                .andExpect(status().isOk());

    }

}