package com.todo.todolist.domain.security;

import com.todo.todolist.domain.entity.UserEntity;
import com.todo.todolist.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomLoadUserByUsername implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findUserEntityByUserId(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found User"));

        return user;
    }
}
