package com.todo.todolist.domain.controller;

import com.todo.todolist.domain.dto.UserDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @PostMapping
    public ResponseEntity register(@RequestBody @Valid UserDto userDto){

        return null;
    }

}

