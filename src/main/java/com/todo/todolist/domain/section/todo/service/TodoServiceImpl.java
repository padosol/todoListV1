package com.todo.todolist.domain.section.todo.service;

import com.todo.todolist.domain.section.todo.dto.InsertTodo;
import com.todo.todolist.domain.section.todo.dto.TodoDto;
import com.todo.todolist.domain.section.todo.entity.TodoEntity;
import com.todo.todolist.domain.section.todo.repository.TodoRepository;
import com.todo.todolist.domain.user.entity.UserEntity;
import com.todo.todolist.domain.user.repository.UserRepository;
import com.todo.todolist.domain.user.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Override
    public TodoDto addTodos(InsertTodo insertTodo) {

        String userEmail = UserUtils.getUserName();

        UserEntity userEntity = userRepository.findOneWithAuthoritiesByEmail(userEmail).get();

        TodoEntity entity = insertTodo.toEntity();
        entity.setUserEntity(userEntity);
        entity.setCreateDate(LocalDateTime.now());

        TodoEntity save = todoRepository.save(entity);

        return save.toDto();
    }
}
