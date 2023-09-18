package com.todo.todolist.domain.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private String message;
    private HttpStatus httpStatus;

    public ErrorResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
