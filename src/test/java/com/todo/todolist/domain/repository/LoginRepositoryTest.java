package com.todo.todolist.domain.repository;

import com.todo.todolist.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginRepositoryTest {

    @Autowired
    private UserRepository loginRepository;



}