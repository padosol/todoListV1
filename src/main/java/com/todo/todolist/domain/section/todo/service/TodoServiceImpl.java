package com.todo.todolist.domain.section.todo.service;

import com.todo.todolist.domain.section.todo.dto.InsertTodo;
import com.todo.todolist.domain.section.todo.dto.TodoDto;
import com.todo.todolist.domain.section.todo.entity.TodoEntity;
import com.todo.todolist.domain.section.todo.repository.TodoRepository;
import com.todo.todolist.domain.user.entity.UserEntity;
import com.todo.todolist.domain.user.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;
    @Override
    public TodoDto addTodos(InsertTodo insertTodo) {

        UserEntity userInfo = UserUtils.getUserInfo();

        TodoEntity save = todoRepository.save(insertTodo.toEntity());

        return save.toDto();
    }
}
