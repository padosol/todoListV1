package com.todo.todolist.domain.section.project_manage;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.header.Header;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProjectController {


    // 프로젝트 생성
    @GetMapping("/v1/projects")
    public ResponseEntity<ByteArrayResource> generateProject() {

        WebClient webClient = WebClient.create("https://start.spring.io");

        byte[] zipByte = webClient.get()
                .uri("/starter.zip")
                .retrieve()
                .bodyToMono(byte[].class)
                .block();


        // 해당 zip 파일을 gitlab 에 올리고 url 반환

        // gitlab api 등록 해야함
        HttpHeaders headers = new HttpHeaders();
        headers.setContentLength(zipByte.length);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "example.zip");

        return new ResponseEntity<>(new ByteArrayResource(zipByte), headers, HttpStatus.OK);
    }





}
