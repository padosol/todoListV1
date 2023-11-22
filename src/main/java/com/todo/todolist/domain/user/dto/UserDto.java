package com.todo.todolist.domain.user.dto;

import com.todo.todolist.domain.user.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    @NotBlank
    private String userEmail;
    @NotBlank
    private String password;
    @NotBlank
    private String name;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .username(userEmail)
                .password(password)
                .name(name).build();
    }

}