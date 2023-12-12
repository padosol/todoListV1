package com.todo.todolist.domain.section.todo.controller;

import com.todo.todolist.domain.section.todo.dto.InsertTodo;
import com.todo.todolist.domain.section.todo.dto.TodoDto;
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

    @GetMapping("/v1/todos")
    public ResponseEntity<List<TodoDto>> getTodos() {
        List<TodoDto> todos = todoService.getTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PostMapping("/v1/todos")
    public ResponseEntity<TodoDto> addTodos(@RequestBody @Valid InsertTodo insertTodo) {

        TodoDto todoDto = todoService.addTodos(insertTodo);

        return new ResponseEntity<>(todoDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/v1/todos/{todoId}")
    public ResponseEntity<Void> removeTodos(@PathVariable Long todoId){


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
