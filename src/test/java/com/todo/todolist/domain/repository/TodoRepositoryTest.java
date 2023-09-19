package com.todo.todolist.domain.repository;

import com.todo.todolist.domain.entity.TodoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoRepositoryTest {


    @Autowired
    private TodoRepository todoRepository;


    @Test
    void todoListAdd(){

        // given
        String title = "test";
        String content = "test";

        todoRepository.save(TodoEntity.builder()
                .title(title)
                .content(content)
                .build());

        // when
        List<TodoEntity> all = todoRepository.findAll();


        // then

    }


}