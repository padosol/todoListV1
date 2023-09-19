package com.todo.todolist.domain.repository;

import com.todo.todolist.domain.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

}
