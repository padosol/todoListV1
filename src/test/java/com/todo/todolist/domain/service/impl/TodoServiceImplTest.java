package com.todo.todolist.domain.service.impl;

import com.todo.todolist.domain.controller.TodoController;
import com.todo.todolist.domain.entity.TodoEntity;
import com.todo.todolist.domain.repository.TodoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(TodoController.class)
class TodoServiceImplTest {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    MockMvc mvc;

    @Test
    void 조회() throws Exception {

        // given
        Long id = 1L;

        //when
        mvc.perform(MockMvcRequestBuilders
                .get("/api/v1/todo/"+id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        //then


    }

    @Test
    void 등록(){
        // given
        TodoEntity todo = TodoEntity.builder()
                .content("테스트 1")
                .title("테스트 입니다.")
                .regDate(LocalDateTime.now()).build();

        // when
        TodoEntity save = todoRepository.save(todo);

        Optional<TodoEntity> byId = todoRepository.findById(save.getTodoId());


        // then
        Assertions.assertThat(save.getTodoId()).isEqualTo(byId.get().getTodoId());

    }

    @Test
    void 수정(){
        // given
        TodoEntity todo = todoRepository.findById(1L).get();
        todo.setContent("테스트1 변경");

        // when
        TodoEntity save = todoRepository.save(todo);

        // then
        Assertions.assertThat(save.getContent()).isEqualTo(todo.getContent());

    }

    void 삭제(){

    }

}