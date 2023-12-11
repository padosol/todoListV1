package com.todo.todolist.domain.user.utils;

import com.todo.todolist.domain.jwt.TokenProvider;
import com.todo.todolist.domain.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

@RequiredArgsConstructor
public class UserUtils {

    private final TokenProvider tokenProvider;


    public static String getUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }


}
