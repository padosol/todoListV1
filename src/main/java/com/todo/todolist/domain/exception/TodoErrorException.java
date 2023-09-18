package com.todo.todolist.domain.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class TodoErrorException extends RuntimeException{

    private String errorMessage;
    private ErrorStatus errorStatus;
    private HttpStatus httpStatus;

    public TodoErrorException(String message, ErrorStatus errorStatus, String errorMessage, HttpStatus httpStatus) {
        super(message);
        this.errorMessage = errorMessage;
        this.errorStatus = errorStatus;
        this.httpStatus = httpStatus;
    }

}
