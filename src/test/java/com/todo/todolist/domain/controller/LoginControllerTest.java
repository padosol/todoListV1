package com.todo.todolist.domain.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.todolist.domain.dto.LoginDto;
import com.todo.todolist.domain.service.LoginService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class LoginControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private LoginDto loginDto;

    @MockBean
    private LoginService loginService;

    @Test
    void 로그인테스트() throws Exception {

        LoginDto loginDto = new LoginDto();
        loginDto.setUserId("test");
        loginDto.setPassword("test");
        ObjectMapper mapper = new ObjectMapper();

        mvc.perform(MockMvcRequestBuilders.post("/api/v1/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(loginDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }
    
    @Test
    @DisplayName("유저 조회 테스트")
    void 유저조회테스트() {

        // given
        loginDto = new LoginDto();
        loginDto.setUserId("test");
        loginDto.setPassword("test");

        // when


        // then









    }


}