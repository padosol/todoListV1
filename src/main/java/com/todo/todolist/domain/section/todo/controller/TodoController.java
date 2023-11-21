package com.todo.todolist.domain.section.todo.controller;

import com.todo.todolist.domain.section.todo.dto.*;
import com.todo.todolist.domain.section.todo.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // 조회
    @GetMapping(value = "/v1/todos")
    public ResponseEntity<List<TodoResponseDto>> getTodos() {

        try {

            List<TodoResponseDto> todos = todoService.getTodos();

            return new ResponseEntity<>(todos, HttpStatus.OK);
        } catch(Exception e) {
            throw e;
        }
    }

    // 상세정보
    @GetMapping(value = "/v1/todos/{todoId}")
    public ResponseEntity<TodoResponseDto> getTodo(@PathVariable Long todoId) {
        return null;
    }

    // 등록
    @PostMapping(value = "/v1/todos/{todoId}")
    public ResponseEntity<Void> addTodo(@PathVariable Long todoId,
                                        @RequestBody @Valid TodoInsertDto todoInsertDto) {
        return null;
    }

    // 수정
    @PutMapping(value = "/v1/todos/{todoId}")
    public ResponseEntity<Void> modifyTodo(@PathVariable Long todoId,
                                           @RequestBody @Valid TodoUpdateDto todoUpdateDto) {
        return null;
    }

    // 삭제
    @DeleteMapping(value = "/v1/todos/{todoId}")
    public ResponseEntity<Void> removeTodo(@PathVariable Long todoId,
                                           @RequestBody @Valid TodoDeleteDto todoDeleteDto) {
        return null;
    }


}
