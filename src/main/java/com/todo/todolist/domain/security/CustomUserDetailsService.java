package com.todo.todolist.domain.security;

import com.todo.todolist.domain.entity.UserEntity;
import com.todo.todolist.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity entity = userRepository.findUserEntityByUserEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));

        return User.builder()
                .username(entity.getUserEmail())
                .password(entity.getPassword())
                .roles(entity.getRole())
                .build();
    }
}
