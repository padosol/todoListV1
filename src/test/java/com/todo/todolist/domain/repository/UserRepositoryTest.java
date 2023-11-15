package com.todo.todolist.domain.repository;

import com.todo.todolist.domain.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    void 유저등록(){

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //given
        UserEntity entity = UserEntity.builder()
                .userEmail("hzyan2@gmail.com")
                .password(passwordEncoder.encode("test"))
                .role("USER")
                .name("test").build();

        userRepository.save(entity);
        //when


        //then


    }

}