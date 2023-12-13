package com.todo.todolist.domain.section.todo.repository;

import com.todo.todolist.domain.section.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    List<TodoEntity> findAllByUserEntity_IdOrderByCreateDate(Long id);

}
