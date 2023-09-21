package com.todo.todolist.domain.service;

import com.todo.todolist.domain.dto.LoginDto;

public interface LoginService {

    boolean login(LoginDto loginDto);

    void logout();

}
