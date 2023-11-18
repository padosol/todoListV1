package com.todo.todolist.domain.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.todolist.domain.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;

public class AjaxAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private ObjectMapper objectMapper = new ObjectMapper();


    public AjaxAuthenticationFilter() {
        super(new AntPathRequestMatcher("/api/login"));
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        if(!isAjax(request)) {
            throw new IllegalStateException("Authentication is not supported");
        }

        BufferedReader reader = request.getReader();

        AccountDto accountDto = objectMapper.readValue(request.getReader(), AccountDto.class);

        if(!StringUtils.hasLength(accountDto.getUsername()) || !StringUtils.hasLength(accountDto.getPassword())) {
            throw new IllegalArgumentException("username or password is empty");
        }

        AjaxAuthenticationToken token = new AjaxAuthenticationToken(
                accountDto.getUsername(),
                accountDto.getPassword()
        );

        return getAuthenticationManager().authenticate(token);
    }

    private boolean isAjax(HttpServletRequest request) {

        if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            return true;
        }

        return false;
    }

}
