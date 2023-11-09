package com.todo.todolist.domain.dto;

import lombok.Data;

@Data
public class TodoDelete {

    private String userId;

    private Long todoId;

}
