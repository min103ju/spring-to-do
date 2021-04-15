package com.security.todo.model.dto;

import com.security.todo.model.domain.Todo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;



@AllArgsConstructor
@Data
@Getter
@Setter
public class TodoDto {

    private Long pkey;
    private String content;
    private String writer;
    private boolean complete;
    private Instant createDate;
    private Instant completeDate;

    public Todo toEntity() {
        return Todo.builder()
                .pkey(this.getPkey())
                .content(this.getContent())
                .writer(this.getWriter())
                .complete(this.isComplete())
                .createDate(this.getCreateDate())
                .completeDate(this.getCompleteDate())
                .build();
    }

}
