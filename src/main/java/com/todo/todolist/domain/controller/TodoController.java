package com.todo.todolist.domain.controller;

import com.todo.todolist.domain.dto.TodoInsert;
import com.todo.todolist.domain.exception.ErrorMessages;
import com.todo.todolist.domain.exception.ErrorStatus;
import com.todo.todolist.domain.exception.TodoErrorException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoController {


    // select
    @GetMapping()
    public ResponseEntity<?> todoList(){

        return null;
    }


    // insert
    @PostMapping()
    public ResponseEntity<?> addTodo(@RequestBody @Valid TodoInsert todoInsert, BindingResult bindingResult){

        return null;
    }


    // update
    @PutMapping()
    public ResponseEntity<?> modifyTodo(){
        return null;
    }


    // delete
    @DeleteMapping()
    public ResponseEntity<?> removeTodo(){

        return null;
    }



}
