package com.todo.todolist.domain.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.todo.todolist.domain.service.OAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/oauth2")
@RequiredArgsConstructor
public class OAuthController {

    private final OAuthService oAuthService;

    @GetMapping("/code/{registrationId}")
    public String googleLogin(@RequestParam String code, @PathVariable String registrationId) {
        System.out.println(code);
        System.out.println(registrationId);

        String accessToken = oAuthService.getAccessToken(code, registrationId);
        JsonNode userResource = oAuthService.getUserResource(accessToken);

        return accessToken;
    }


}
