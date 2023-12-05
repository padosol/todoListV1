package com.todo.todolist.domain.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginDto {

    private String email;
    private String password;

}
