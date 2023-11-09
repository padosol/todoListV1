package com.todo.todolist.domain.service.impl;

import com.todo.todolist.domain.dto.TodoDelete;
import com.todo.todolist.domain.dto.TodoInsert;
import com.todo.todolist.domain.dto.TodoList;
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

        todoRepository.save(todo);
    }

    @Override
    public void updateTodo(TodoUpdate todoUpdate) {

        TodoEntity existTodo = todoRepository.findById(todoUpdate.getTodoId()).get();
        existTodo.setTitle(todoUpdate.getTitle());
        existTodo.setContent(todoUpdate.getContent());

        // save by
        todoRepository.save(existTodo);
    }

    @Override
    public void deleteTodo(TodoDelete todoDelete) {

        TodoEntity todo = TodoEntity.builder()
                        .todoId(todoDelete.getTodoId()).build();

        todoRepository.delete(todo);
    }

    @Override
    public List<ToDoList> selectAllTodo(String userId) {
        return null;
    }

    @Override
    public TodoList selectOneTodo(String userId, Long todoId) {
        TodoEntity todo = todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException());

        return TodoList.builder()
                .title(todo.getTitle())
                .content(todo.getContent()).build();
    }

}
