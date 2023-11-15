package com.todo.todolist.domain.security;

import com.todo.todolist.domain.entity.UserEntity;
import com.todo.todolist.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomLoadUserByUsername implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findUserEntityByUserEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found User"));

        log.info("Success find user {}", user);

        System.out.println(user);

        return User.builder()
                .username(user.getUserEmail())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}
