package com.todo.todolist.domain.user.dto;

import lombok.Data;

@Data
public class UserDto {

    private String email;
    private String password;
    private String name;
    private String roles;

}
