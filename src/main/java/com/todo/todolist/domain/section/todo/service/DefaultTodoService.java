package com.todo.todolist.domain.section.todo.service;

import com.todo.todolist.domain.section.todo.dto.TodoDeleteDto;
import com.todo.todolist.domain.section.todo.dto.TodoInsertDto;
import com.todo.todolist.domain.section.todo.dto.TodoResponseDto;
import com.todo.todolist.domain.section.todo.dto.TodoUpdateDto;
import com.todo.todolist.domain.section.todo.entity.TodoEntity;
import com.todo.todolist.domain.section.todo.repository.TodoRepository;
import com.todo.todolist.domain.user.entity.UserEntity;
import com.todo.todolist.domain.user.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultTodoService implements TodoService{

    private final TodoRepository todoRepository;

    @Override
    public List<TodoResponseDto> getTodos() {

        UserEntity userInfo = UserUtils.getUserInfo();

        List<TodoResponseDto> collect = todoRepository.findAllByUserEntity_Username(userInfo.getUsername())
                .stream()
                .map(TodoResponseDto::new)
                .collect(Collectors.toList());

        return collect;
    }

    @Override
    public TodoResponseDto getTodo(Long todoId) {
        return null;
    }

    @Override
    public void addTodo(TodoInsertDto todoInsertDto) {

        UserEntity userInfo = UserUtils.getUserInfo();

        TodoEntity entity = todoInsertDto.toEntity();
        entity.setUserEntity(userInfo);

        todoRepository.save(entity);
    }

    @Override
    public void modifyTodo(Long todoId, TodoUpdateDto todoUpdateDto) {

        TodoEntity todoEntity = todoRepository.findById(todoId).get();





    }

    @Override
    public void removeTodo(Long todoId) {

        TodoEntity todoEntity = todoRepository.findById(todoId).get();

        todoRepository.delete(todoEntity);

    }



}
