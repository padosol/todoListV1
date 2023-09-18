package com.todo.todolist.domain.exception;

public enum ErrorMessages {
    VALID_ERROR("올바른 데이터가 아닙니다.");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }
}
