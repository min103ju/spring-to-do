package com.security.todo.model.request;

import com.security.todo.model.Todo;
import com.security.todo.model.response.TodoResp;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Data
@Getter
@Setter
public class TodoReq {

    private Long pkey;
    private String content;
    private String writer;
    private boolean complete;
    private Instant createDate;
    private Instant completeDate;

    public static Todo makeDomain(TodoReq todoReq) {
        return Todo.builder()
                .pkey(todoReq.getPkey())
                .content(todoReq.getContent())
                .writer(todoReq.getWriter())
                .complete(todoReq.isComplete())
                .createDate(todoReq.getCreateDate())
                .completeDate(todoReq.getCompleteDate())
                .build();
    }

}
