package com.todo.todolist.domain.user.service;

import com.todo.todolist.domain.user.dto.Account;
import com.todo.todolist.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void addUsers(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        userRepository.save(account.toEntity());
    }
}
