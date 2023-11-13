package com.todo.todolist.domain.security;

import com.todo.todolist.domain.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final CustomLoadUserByUsername customLoadUserByUsername;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UserEntity user = (UserEntity) customLoadUserByUsername.loadUserByUsername(authentication.getName());
        String reqPassword = authentication.getCredentials().toString();

        if(!passwordEncoder.matches(reqPassword, user.getPassword()))
            throw new BadCredentialsException("Not Found User");

        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
