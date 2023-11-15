package com.todo.todolist.domain.service;

import com.todo.todolist.domain.dto.UserDto;
import com.todo.todolist.domain.entity.UserEntity;

public interface UserService {


    // 회원가입
    String registerUser(UserDto userDto);

    // 아이디 중복체크
    String findUserById(String userEmail);

    UserEntity getUserInfo();


}
