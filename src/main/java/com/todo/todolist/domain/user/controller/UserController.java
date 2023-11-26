package com.todo.todolist.domain.user.controller;

import com.todo.todolist.domain.user.dto.UserDto;
import com.todo.todolist.domain.user.entity.UserEntity;
import com.todo.todolist.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

        try {
            UserEntity userInfo = userService.getUserInfo();

            return new ResponseEntity<>(userInfo, HttpStatus.OK);
        } catch(UsernameNotFoundException e) {
            e.printStackTrace();
            throw e;
        }

    }

    // test
    @PostMapping("/users")
    public ResponseEntity<Void> addUsers() {

        return null;
    }

}

