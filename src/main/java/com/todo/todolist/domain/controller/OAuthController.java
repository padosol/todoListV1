package com.todo.todolist.domain.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/oauth2")
public class OAuthController {

    @GetMapping("/code/{registrationId}")
    public String googleLogin(@RequestParam String code, @PathVariable String registrationId) {
        System.out.println(code);
        System.out.println(registrationId);

        return code + " / " + registrationId;
    }
}
