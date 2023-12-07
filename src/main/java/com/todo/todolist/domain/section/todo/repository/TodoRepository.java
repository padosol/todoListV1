package com.todo.todolist.domain.section.todo.repository;

import com.todo.todolist.domain.section.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {


}
