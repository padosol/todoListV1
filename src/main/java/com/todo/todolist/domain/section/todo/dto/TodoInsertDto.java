package com.todo.todolist.domain.section.todo.dto;

import com.todo.todolist.domain.section.todo.entity.TodoEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class TodoInsertDto {

    @NotBlank
    private String title;
    @NotBlank
    private String contents;
    private String state;

    public TodoEntity toEntity(){
        return TodoEntity.builder()
                .title(title)
                .contents(contents).build();
    }

}
