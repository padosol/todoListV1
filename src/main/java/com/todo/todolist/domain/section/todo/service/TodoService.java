package com.todo.todolist.domain.section.todo.service;

import com.todo.todolist.domain.section.todo.dto.InsertTodo;
import com.todo.todolist.domain.section.todo.dto.TodoDto;

public interface TodoService {

    TodoDto addTodos(InsertTodo insertTodo);
}
