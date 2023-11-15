package com.todo.todolist.domain.service.impl;

import com.todo.todolist.domain.dto.UserDto;
import com.todo.todolist.domain.entity.UserEntity;
import com.todo.todolist.domain.repository.UserRepository;
import com.todo.todolist.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String registerUser(UserDto userDto) {

        UserEntity user = userDto.toEntity();

        return  userRepository.save(user).getUserEmail();
    }

    @Override
    public String findUserById(String id) {
        UserEntity user = userRepository.findUserEntityByUserEmail(id).get();
        return null;
    }

    @Override
    public UserEntity getUserInfo() {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findUserEntityByUserEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found User"));
    }
}
