package com.todo.todolist.domain.repository;

import com.todo.todolist.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findUserEntityByUserId(String userId);

}
