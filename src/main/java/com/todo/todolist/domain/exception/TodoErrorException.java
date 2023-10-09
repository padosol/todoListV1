package com.todo.todolist.domain.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class TodoErrorException extends RuntimeException{

    private String errorMessage;
    private HttpStatus httpStatus;

    public TodoErrorException(String message, String errorMessage, HttpStatus httpStatus) {
        super(message);
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

}
