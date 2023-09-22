package com.todo.todolist.domain.service.impl;

import com.todo.todolist.domain.dto.UserDto;
import com.todo.todolist.domain.entity.UserEntity;
import com.todo.todolist.domain.repository.UserRepository;
import com.todo.todolist.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Long registerUser(UserDto userDto) {

        UserEntity user = userDto.toEntity();

        return  userRepository.save(user).getId();
    }

    @Override
    public Long findUserById(String id) {
        UserEntity user = userRepository.findUserEntityByUserId(id);
        return null;
    }
}
