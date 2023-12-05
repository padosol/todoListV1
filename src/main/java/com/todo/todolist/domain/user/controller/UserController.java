package com.todo.todolist.domain.user.controller;

import com.todo.todolist.domain.user.dto.UserDto;
import com.todo.todolist.domain.user.entity.UserEntity;
import com.todo.todolist.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserEntity> signup(@RequestBody @Valid UserDto userDto) {
        return new ResponseEntity<>(userService.signup(userDto), HttpStatus.OK);
    }

    @PostMapping("/user")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<String> getMyUserInfo() {
        return ResponseEntity.ok("user");
    }

    @PostMapping("/user/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<String> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok("admin");
    }



}

