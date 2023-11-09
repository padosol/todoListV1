package com.todo.todolist.domain.controller;

import com.todo.todolist.domain.dto.TodoDelete;
import com.todo.todolist.domain.dto.TodoInsert;
import com.todo.todolist.domain.dto.TodoList;
import com.todo.todolist.domain.dto.TodoUpdate;
import com.todo.todolist.domain.service.TodoService;
import com.todo.todolist.domain.vo.ToDoList;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoController {

    private final TodoService todoService;

    // select
    @GetMapping()
    public ResponseEntity<?> todoList(){

        return null;
    }

    // selectOne
    @GetMapping("/{id}")
    public ResponseEntity<TodoList> getTodoList(@PathVariable Long id){

        try {
            TodoList toDoList = todoService.selectOneTodo(null, id);

            return new ResponseEntity<>(toDoList, HttpStatus.OK);
        } catch(Exception e){
            throw e;
        }

    }

    // insert
    @PostMapping()
    public ResponseEntity<?> addTodo(@RequestBody @Valid TodoInsert todoInsert){

        try {
            todoService.insertTodo(todoInsert);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception e){
            throw new RuntimeException();
        }

    }

    // update
    @PutMapping()
    public ResponseEntity<?> modifyTodo(TodoUpdate todoUpdate){
        try {
            todoService.updateTodo(todoUpdate);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            throw e;
        }
    }

    // delete
    @DeleteMapping()
    public ResponseEntity<?> removeTodo(TodoDelete todoDelete){

        try {
            todoService.deleteTodo(todoDelete);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e){
            throw e;
        }
    }

}
