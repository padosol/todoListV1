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

    // 전체조회
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
    @PostMapping(value = "/v1/todos")
    public ResponseEntity<Void> addTodo(@RequestBody @Valid TodoInsertDto todoInsertDto) {

        try {
            todoService.addTodo(todoInsertDto);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception e) {
            throw e;
        }

    }

    // 수정
    @PutMapping(value = "/v1/todos")
    public ResponseEntity<Void> modifyTodo(@RequestBody @Valid TodoUpdateDto todoUpdateDto) {

        try {
            todoService.modifyTodo(todoUpdateDto);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            throw e;
        }
    }

    // 삭제
    @DeleteMapping(value = "/v1/todos")
    public ResponseEntity<Void> removeTodo(@PathVariable Long todoId) {

        try {
            todoService.removeTodo(todoId);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            throw e;
        }

    }

}
