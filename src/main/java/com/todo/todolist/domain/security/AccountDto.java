package com.todo.todolist.domain.security;

import lombok.Data;

@Data
public class AccountDto {
    private String username;
    private String password;
    private String role;
}
