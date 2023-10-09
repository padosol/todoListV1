package com.todo.todolist.domain.service.impl;

import com.todo.todolist.domain.dto.TodoInsert;
import com.todo.todolist.domain.dto.TodoUpdate;
import com.todo.todolist.domain.entity.TodoEntity;
import com.todo.todolist.domain.repository.TodoRepository;
import com.todo.todolist.domain.service.TodoService;
import com.todo.todolist.domain.vo.ToDoList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public void insertTodo(TodoInsert todoInsert) {

        TodoEntity todo = TodoEntity.builder()
                        .title(todoInsert.getTitle())
                        .content(todoInsert.getContent()).build();

        //test

        todoRepository.save(todo);
    }

    @Override
    public void updateTodo(TodoUpdate todoUpdate) {
    }

    @Override
    public List<ToDoList> selectAllTodo(String userId) {
        return null;
    }

    @Override
    public ToDoList selectOneTodo(String userId, String todoId) {
        return null;
    }
}
