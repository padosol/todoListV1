package com.todo.todolist.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class SpringIO {

    public static void main(String[] args) {


        String defaultUrl = "https://start.spring.io/starter.zip";

        WebClient webClient = WebClient.create();

        byte[] block = webClient.get()
                .uri(defaultUrl)
                .accept(MediaType.APPLICATION_OCTET_STREAM)
                .retrieve()
                .bodyToMono(byte[].class)
                .block();


        System.out.println(block);


    }


}
