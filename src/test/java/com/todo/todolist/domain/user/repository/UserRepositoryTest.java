package com.todo.todolist.domain.user.repository;

import com.todo.todolist.domain.user.entity.UserEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
                .email("test@test.com")
                .password(passwordEncoder.encode("test"))
                .build();

        userRepository.save(user);

        UserEntity userEntity = userRepository.findOneWithAuthoritiesByEmail("test@test.com").get();

        Assertions.assertThat(userEntity.getEmail()).isEqualTo(user.getEmail());

    }


}