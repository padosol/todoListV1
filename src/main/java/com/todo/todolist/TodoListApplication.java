package com.todo.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoListApplication {

    public static void main(String[] args) {

        System.out.println("CI / CD 4");

        SpringApplication.run(TodoListApplication.class, args);
    }

}
