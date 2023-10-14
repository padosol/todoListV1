package com.todo.todolist.domain.service;

import com.todo.todolist.domain.dto.TodoDelete;
import com.todo.todolist.domain.dto.TodoInsert;
import com.todo.todolist.domain.dto.TodoUpdate;
import com.todo.todolist.domain.vo.ToDoList;

import java.util.List;

public interface TodoService {

    void insertTodo(TodoInsert todoInsert);

    void updateTodo(TodoUpdate todoUpdate);

    void deleteTodo(TodoDelete todoDelete);

    List<ToDoList> selectAllTodo(String userId);

    ToDoList selectOneTodo(String userId, String todoId);


}
