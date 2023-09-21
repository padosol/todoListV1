package com.todo.todolist.domain.controller;

import com.todo.todolist.domain.dto.LoginDto;
import com.todo.todolist.domain.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDto loginDto){

        boolean isSuccess = loginService.login(loginDto);

//        if(isSuccess) {
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<?> logout(){


        return null;
    }
}
