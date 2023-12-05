package com.todo.todolist.domain.config;

import com.todo.todolist.domain.jwt.JwtAccessDeniedHandler;
import com.todo.todolist.domain.jwt.JwtAuthenticationEntryPoint;
import com.todo.todolist.domain.jwt.JwtFilter;
import com.todo.todolist.domain.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{


    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final TokenProvider tokenProvider;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)

                .exceptionHandling(exception -> exception
                        .accessDeniedHandler(jwtAccessDeniedHandler)
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint))

                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(request -> request
                        .requestMatchers("/api/signup").permitAll()
                        .requestMatchers("/api/authenticate").permitAll()
                        .anyRequest().authenticated())

                .addFilterBefore(new JwtFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class)
        ;

        return http.build();
    }

//    @Bean
//    public CustomAuthenticationFilter ajaxAuthenticationFilter() throws Exception {
//        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter();
//        customAuthenticationFilter.setAuthenticationManager(authenticationManager());
//        customAuthenticationFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler);
//        customAuthenticationFilter.setAuthenticationFailureHandler(customAuthenticationFailureHandler);
//        customAuthenticationFilter.setSecurityContextRepository(
//                new DelegatingSecurityContextRepository(
//                        new RequestAttributeSecurityContextRepository(),
//                        new HttpSessionSecurityContextRepository()
//                ));
//
//        return customAuthenticationFilter;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager() throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

}
