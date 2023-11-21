package com.todo.todolist.domain.user.utils;

import com.todo.todolist.domain.user.entity.UserEntity;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {

    public static UserEntity getUserInfo() {
        return (UserEntity) SecurityContextHolder.getContext().getAuthentication();
    }



}
