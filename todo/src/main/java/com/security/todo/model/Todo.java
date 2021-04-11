package com.security.todo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkey;
    private String content;
    private boolean complete = false;
    private Instant createDate = Instant.now();
    private Instant completeDate;

    public boolean isComplete() {
        return this.complete;
    }

}
