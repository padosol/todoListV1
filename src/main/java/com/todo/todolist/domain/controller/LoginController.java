package com.todo.todolist.domain.controller;

import com.todo.todolist.domain.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping(value = "/login/success")
    public ResponseEntity<?> login(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("test");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/login/fail")
    public ResponseEntity<?> loginFail() {

        System.out.println("로그인 실패");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<?> logout(){


        return null;
    }
}
