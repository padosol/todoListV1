package com.todo.todolist.domain.user.dto;

import com.todo.todolist.domain.user.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Account {

    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private boolean isAgree;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .email(email)
                .password(password).build();

    }

}
