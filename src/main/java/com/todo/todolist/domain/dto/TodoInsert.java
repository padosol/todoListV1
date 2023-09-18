package com.todo.todolist.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TodoInsert {

    @NotBlank
    private String userId;

    @NotNull
    private String title;

    private String content;

}
