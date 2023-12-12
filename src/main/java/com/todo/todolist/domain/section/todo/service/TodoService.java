package com.todo.todolist.domain.section.todo.service;

import com.todo.todolist.domain.section.todo.dto.InsertTodo;
import com.todo.todolist.domain.section.todo.dto.TodoDto;
import com.todo.todolist.domain.section.todo.dto.UpdateTodo;

import java.util.List;

public interface TodoService {

    List<TodoDto> getTodos();

    TodoDto addTodos(InsertTodo insertTodo);

    void removeTodo(Long todoId);

    TodoDto modifyTodo(UpdateTodo updateTodo);
}
