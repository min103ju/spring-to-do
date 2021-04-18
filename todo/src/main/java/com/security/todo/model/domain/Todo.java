package com.security.todo.model.domain;

import com.security.todo.model.dto.TodoDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Getter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkey;
    private String content;
    private String writer;
    @Builder.Default
    private Boolean complete = false;
    @Builder.Default
    private Instant createDate = Instant.now();
    private Instant completeDate;

    public TodoDto todoDto() {
        return new TodoDto(
                this.pkey,
                this.content,
                this.writer,
                this.complete,
                this.createDate,
                this.completeDate
        );
    }

    @Override
    public String toString() {
        return "Todo{" +
                "pkey=" + pkey +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", complete=" + complete +
                ", createDate=" + createDate +
                ", completeDate=" + completeDate +
                '}';
    }
}
