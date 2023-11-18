package com.todo.todolist.domain.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.todolist.domain.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class AjaxAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private ObjectMapper objectMapper = new ObjectMapper();


    public AjaxAuthenticationFilter() {
        super(new AntPathRequestMatcher("/api/login"), new ProviderManager());
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        if(isAjax(request)) {
            throw new IllegalStateException("Authentication is not supported");
        }

        UserDto userDto = objectMapper.readValue(request.getReader(), UserDto.class);
        if(!StringUtils.hasLength(userDto.getUserEmail()) || !StringUtils.hasLength(userDto.getPassword())) {
            throw new IllegalArgumentException("username or password is empty");
        }

        AjaxAuthenticationToken token = new AjaxAuthenticationToken(
                userDto.getUserEmail(),
                userDto.getPassword()
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
