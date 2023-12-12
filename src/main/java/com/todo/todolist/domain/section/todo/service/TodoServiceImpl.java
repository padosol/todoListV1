package com.todo.todolist.domain.section.todo.service;

import com.todo.todolist.domain.section.todo.dto.InsertTodo;
import com.todo.todolist.domain.section.todo.dto.TodoDto;
import com.todo.todolist.domain.section.todo.dto.UpdateTodo;
import com.todo.todolist.domain.section.todo.entity.TodoEntity;
import com.todo.todolist.domain.section.todo.repository.TodoRepository;
import com.todo.todolist.domain.user.entity.UserEntity;
import com.todo.todolist.domain.user.repository.UserRepository;
import com.todo.todolist.domain.user.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Override
    public List<TodoDto> getTodos() {
        String userEmail = UserUtils.getUserName();

        UserEntity userEntity = userRepository.findOneWithAuthoritiesByEmail(userEmail).get();

        return todoRepository.findAllByUserEntity_Id(userEntity.getId())
                .stream()
                .map(TodoEntity::toDto)
                .collect(Collectors.toList());
    }

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

    @Override
    public void removeTodo(Long todoId) {

        Optional<TodoEntity> byId = todoRepository.findById(todoId);

    }

    @Override
    public TodoDto modifyTodo(UpdateTodo updateTodo) {
        return null;
    }
}
