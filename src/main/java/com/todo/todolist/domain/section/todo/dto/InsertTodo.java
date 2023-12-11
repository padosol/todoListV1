package com.todo.todolist.domain.section.todo.dto;

import com.todo.todolist.domain.section.todo.entity.TodoEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InsertTodo {

    @NotBlank
    @Size(min = 1, max = 100)
    private String contents;

    public TodoEntity toEntity() {

        return TodoEntity.builder()
                .contents(contents)
                .build();
    }

}
