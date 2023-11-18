package com.todo.todolist.domain.config;

import com.todo.todolist.domain.handler.CustomAuthenticationFailureHandler;
import com.todo.todolist.domain.handler.CustomAuthenticationSuccessHandler;
import com.todo.todolist.domain.security.AjaxAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{

    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    private final AuthenticationConfiguration authenticationConfiguration;
    private final UserDetailsService userDetailsService;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("http://localhost:5173/login")
                        .loginProcessingUrl("/api/login")
                        .usernameParameter("userEmail")
                        .passwordParameter("password")
                        .successHandler(customAuthenticationSuccessHandler)
                        .failureHandler(customAuthenticationFailureHandler))
                .addFilterBefore(ajaxAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

//                .sessionManagement(session -> session
//                        .maximumSessions(1)
//                        .maxSessionsPreventsLogin(true));

        return http.build();
    }

    @Bean
    public AjaxAuthenticationFilter ajaxAuthenticationFilter() {
        AjaxAuthenticationFilter ajaxAuthenticationFilter = new AjaxAuthenticationFilter();


        return new AjaxAuthenticationFilter();
    }



}
