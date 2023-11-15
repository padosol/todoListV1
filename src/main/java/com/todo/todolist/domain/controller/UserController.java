package com.todo.todolist.domain.controller;

import com.todo.todolist.domain.dto.UserDto;
import com.todo.todolist.domain.entity.UserEntity;
import com.todo.todolist.domain.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity register(@RequestBody @Valid UserDto userDto){

        return null;
    }

    @GetMapping("/me")
    public ResponseEntity<UserEntity> getUserInfo() {

        UserEntity userInfo = userService.getUserInfo();

        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

}

