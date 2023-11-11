package com.todo.todolist.domain.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class OAuthService {

    private final RestTemplate restTemplate = new RestTemplate();
    public String getAccessToken(String requestCode, String registrationId) {

        String clientId = "429467533830-nllp0l2k396j3vki7m29efvjh03dvfgp.apps.googleusercontent.com";
        String clientSecret = "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";
        String redirectUri = "http://localhost:8080/login/oauth2/code/google";
        String tokenUri = "https://oauth2.googleapis.com/token";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", requestCode);
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("redirect_uri", redirectUri);
        params.add("grant_type", "authorization_code");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity entity = new HttpEntity(params, headers);

        ResponseEntity<JsonNode> responseNode = restTemplate.exchange(tokenUri, HttpMethod.POST, entity, JsonNode.class);
        JsonNode accessTokenNode = responseNode.getBody();

        return accessTokenNode.get("access_token").asText();
    }

    public JsonNode getUserResource(String accessToken) {

        String resourceUri = "https://www.googleapis.com/oauth2/v2/userinfo";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity entity = new HttpEntity(headers);

        JsonNode body = restTemplate.exchange(resourceUri, HttpMethod.GET, entity, JsonNode.class).getBody();

        return body;
    }

}
