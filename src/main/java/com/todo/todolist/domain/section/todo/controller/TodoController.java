package com.todo.todolist.domain.section.todo.controller;

import com.todo.todolist.domain.section.todo.dto.TodoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TodoController {

    // 조회
    @GetMapping("/v1/todos")
    public ResponseEntity<List<TodoResponseDto>> getTodos() {


        return null;
    }


    // 상세정보

    // 등록

    // 수정

    // 삭제


}
