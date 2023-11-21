package com.todo.todolist.domain.user.service;

import com.todo.todolist.domain.user.dto.UserDto;
import com.todo.todolist.domain.user.entity.UserEntity;
import com.todo.todolist.domain.user.repository.UserRepository;
import com.todo.todolist.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
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

        return  userRepository.save(user).getUsername();
    }

    @Override
    public String findUserById(String id) {
        UserEntity user = userRepository.findUserEntityByUsername(id).get();
        return null;
    }

    @Override
    public UserEntity getUserInfo() {
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();

        UserEntity user = (UserEntity)authentication.getPrincipal();

        return userRepository.findUserEntityByUsername(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Not Found User"));
    }
}
