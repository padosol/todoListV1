package com.todo.todolist.domain.section.todo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TodoDto {

    private Long todoId;
    private String contents;
    private LocalDateTime createDate;
    private boolean status;

}
