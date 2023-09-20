package com.todo.todolist.domain.service;

import com.todo.todolist.domain.dto.LoginDto;

public interface LoginService {

    void login(LoginDto loginDto);

    void logout();

}
