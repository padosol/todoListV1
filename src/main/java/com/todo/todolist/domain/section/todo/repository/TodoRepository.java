package com.todo.todolist.domain.section.todo.repository;

import com.todo.todolist.domain.section.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findAllByUserEntity_Username(String username);
}
