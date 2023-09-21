package com.todo.todolist.domain.repository;

import com.todo.todolist.domain.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void 유저등록(){

        //given
        UserEntity entity = UserEntity.builder()
                .userId("test")
                .password("test")
                .name("test").build();

        userRepository.save(entity);
        //when


        //then


    }

}