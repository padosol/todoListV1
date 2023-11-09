package com.todo.todolist.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoList {

    private String content;
    private String title;
}
