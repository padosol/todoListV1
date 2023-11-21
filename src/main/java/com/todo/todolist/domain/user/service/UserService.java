package com.todo.todolist.domain.user.service;

import com.todo.todolist.domain.user.dto.UserDto;
import com.todo.todolist.domain.user.entity.UserEntity;

public interface UserService {


    // 회원가입
    String registerUser(UserDto userDto);

    // 아이디 중복체크
    String findUserById(String userEmail);

    UserEntity getUserInfo();


}
