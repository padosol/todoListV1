package com.todo.todolist.domain.section.todo.dto;

import lombok.Data;

@Data
public class UpdateTodo {

    private Long todoId;
    private Boolean status;

}
