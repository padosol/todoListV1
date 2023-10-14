package com.todo.todolist.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TodoUpdate {

    @NotBlank
    private String userId;

    @NotBlank
    private Long todoId;

    @NotNull
    private String title;

    private String content;

}
