package com.todo.todolist.domain.section.todo.repository;

import com.todo.todolist.domain.section.todo.entity.TodoEntity;
import com.todo.todolist.domain.user.entity.UserEntity;
import com.todo.todolist.domain.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@DataJpaTest
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void 유저투두리스트등록() {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 유저 등록 후 해당 유저로 투두 리스트 등록
        UserEntity user = UserEntity.builder()
                .username("test")
                .password(passwordEncoder.encode("test"))
                .name("테스터")
                .role("ROLE_USER")
                .build();

        UserEntity entity = userRepository.save(user);

        TodoEntity todo = TodoEntity.builder()
                .title("테스트중입니다.")
                .contents("정말입니다.")
                .build();

        TodoEntity todo2 = TodoEntity.builder()
                .title("테스트중입니다.")
                .contents("정말입니다.")
                .build();

        todo.setUserEntity(entity);

        TodoEntity save = todoRepository.save(todo);

        TodoEntity todoEntity = todoRepository.findById(save.getTodoId()).get();

        Assertions.assertThat(todoEntity.getUserEntity().getUsername()).isEqualTo(entity.getUsername());

    }

}