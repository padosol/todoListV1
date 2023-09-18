package com.todo.todolist.domain.controller.advice;

import com.todo.todolist.domain.exception.ErrorResponse;
import com.todo.todolist.domain.exception.TodoErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> todoControllerErrors(TodoErrorException e) {

        e.printStackTrace();
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorMessage(), e.getHttpStatus());

        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
    }

}
