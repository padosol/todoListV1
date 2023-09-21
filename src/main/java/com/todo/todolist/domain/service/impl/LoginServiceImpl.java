package com.todo.todolist.domain.service.impl;

import com.todo.todolist.domain.dto.LoginDto;
import com.todo.todolist.domain.entity.UserEntity;
import com.todo.todolist.domain.repository.UserRepository;
import com.todo.todolist.domain.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    @Override
    public boolean login(LoginDto loginDto) {

        UserEntity user = userRepository.findUserEntityByUserId(loginDto.getUserId());

        if(user.getUserId().equals(loginDto.getUserId()) &&
                user.getPassword().equals(loginDto.getPassword())){
            return true;
        }

        return false;
    }

    @Override
    public void logout() {

    }


}