package com.todo.todolist.domain.dto;

import com.todo.todolist.domain.entity.UserEntity;
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
                .userEmail(userEmail)
                .password(password)
                .name(name).build();
    }

}
