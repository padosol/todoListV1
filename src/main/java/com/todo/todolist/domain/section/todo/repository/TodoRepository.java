package com.todo.todolist.domain.section.todo.repository;

import com.todo.todolist.domain.section.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
