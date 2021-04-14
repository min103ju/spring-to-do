package com.security.todo.model.response;

import com.security.todo.model.Todo;
import com.security.todo.model.request.TodoReq;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Builder
@Data
@Getter
@Setter
public class TodoResp {

    private Long pkey;
    private String content;
    private String writer;
    private boolean complete;
    private Instant createDate;
    private Instant completeDate;

    public static TodoResp makeData(Todo todo) {
        return TodoResp.builder()
                .pkey(todo.getPkey())
                .content(todo.getContent())
                .writer(todo.getWriter())
                .complete(todo.isComplete())
                .createDate(todo.getCreateDate())
                .completeDate(todo.getCompleteDate())
                .build();
    }

}
