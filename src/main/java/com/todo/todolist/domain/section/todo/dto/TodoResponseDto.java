package com.todo.todolist.domain.section.todo.dto;

import com.todo.todolist.domain.section.todo.entity.TodoEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoResponseDto {

    private Long todoId;
    private String username;
    private String title;
    private String contents;
    private LocalDateTime registerDate;
    private String state;

    public TodoResponseDto(TodoEntity entity) {
        this.todoId = entity.getTodoId();
        this.username = entity.getUserEntity().getUsername();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
        this.registerDate = entity.getRegisterDate();
    }


}
