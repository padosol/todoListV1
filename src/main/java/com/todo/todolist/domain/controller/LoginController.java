package com.todo.todolist.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(String id, String password){


        return null;
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<?> logout(){


        return null;
    }
}
