package com.todo.todolist.domain.section.todo.controller;

import com.todo.todolist.domain.section.todo.dto.InsertTodo;
import com.todo.todolist.domain.section.todo.dto.TodoDto;
import com.todo.todolist.domain.section.todo.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/v1/todos")
    public ResponseEntity<TodoDto>addTodos(@RequestBody @Valid InsertTodo insertTodo) {

        TodoDto todoDto = todoService.addTodos(insertTodo);

        return new ResponseEntity<>(todoDto, HttpStatus.CREATED);
    }



}
