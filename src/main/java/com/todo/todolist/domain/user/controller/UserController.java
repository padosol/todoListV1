package com.todo.todolist.domain.user.controller;

import com.todo.todolist.domain.user.dto.Account;
import com.todo.todolist.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 유저등록
     * @param account
     * @return
     */
    @PostMapping(value = "/users")
    public ResponseEntity<Account> regUsers(@RequestBody @Valid Account account) {

        userService.addUsers(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/users")
    public ResponseEntity<Void> modifyUsers() {

        return null;
    }

    @DeleteMapping(value = "/users")
    public ResponseEntity<Void> removeUsers() {

        return null;
    }

}

