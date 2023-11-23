package com.todo.todolist.domain.user.repository;

import com.todo.todolist.domain.user.entity.UserEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void 유저등록() {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UserEntity user = UserEntity.builder()
                .username("test")
                .password(passwordEncoder.encode("test"))
                .name("테스터")
                .role("ROLE_USER")
                .build();

        userRepository.save(user);

        UserEntity userEntity = userRepository.findUserEntityByUsername(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("유저없음"));

        System.out.println(userEntity);


    }

    @Test
    void 유저조회() {

        String username = "test";

        UserEntity entity = userRepository.findUserEntityByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("유저없음"));


        Assertions.assertThat(entity.getUsername()).isEqualTo(username);

    }

}