package com.todo.todolist.domain.service;

import com.todo.todolist.domain.dto.UserDto;

public interface UserService {


    // 회원가입
    Long registerUser(UserDto userDto);

    // 아이디 중복체크
    Long findUserById(String id);


}
