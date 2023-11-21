package com.todo.todolist.domain.section.todo.service;

import com.todo.todolist.domain.section.todo.dto.TodoDeleteDto;
import com.todo.todolist.domain.section.todo.dto.TodoInsertDto;
import com.todo.todolist.domain.section.todo.dto.TodoResponseDto;
import com.todo.todolist.domain.section.todo.dto.TodoUpdateDto;

import java.util.List;

public interface TodoService {

    // 조회
    List<TodoResponseDto> getTodos();

    // 상세정보
    TodoResponseDto getTodo(Long todoId);

    // 등록
    void addTodo(TodoInsertDto todoInsertDto);

    // 수정
    void modify(TodoUpdateDto todoUpdateDto);

    // 삭제
    void remove(TodoDeleteDto todoDeleteDto);


}
