package com.todo.todolist.domain.user.service;

import com.todo.todolist.domain.user.dto.UserDto;
import com.todo.todolist.domain.user.entity.UserEntity;

public interface UserService {

    UserEntity signUp(UserDto userDto);

}
