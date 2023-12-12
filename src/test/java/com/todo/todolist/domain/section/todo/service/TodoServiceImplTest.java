package com.todo.todolist.domain.section.todo.service;

import com.todo.todolist.domain.section.todo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TodoServiceImplTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void todoList조회(){



    }

}