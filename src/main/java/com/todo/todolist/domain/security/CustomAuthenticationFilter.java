package com.todo.todolist.domain.security;

import lombok.Data;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private ObjectMapper objectMapper = new ObjectMapper();

    public CustomAuthenticationFilter() {
        super(new AntPathRequestMatcher("/api/login"));
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        if(!isPost(request)) {
            throw new IllegalStateException("Authentication is not supported");
        }

        AccountDto accountDto = objectMapper.readValue(request.getReader(), AccountDto.class);

        if(!StringUtils.hasLength(accountDto.getUsername())
                || !StringUtils.hasLength(accountDto.getPassword())) {
            throw new IllegalArgumentException("username or password is empty");
        }

        // 처음에는 인증 되지 않은 토큰 생성
        CustomAuthenticationToken token = new CustomAuthenticationToken(
                accountDto.getUsername(),
                accountDto.getPassword()
        );

        Authentication authenticate = getAuthenticationManager().authenticate(token);

        return authenticate;
    }

    private boolean isPost(HttpServletRequest request) {

        if("POST".equals(request.getMethod())) {
            return true;
        }

        return false;
    }

    @Data
    public static class AccountDto {
        private String username;
        private String password;
    }

}
