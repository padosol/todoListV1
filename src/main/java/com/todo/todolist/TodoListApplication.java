package com.todo.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoListApplication {

    public static void main(String[] args) {

        System.out.println("CI / CD 수정");

        SpringApplication.run(TodoListApplication.class, args);
    }

}
