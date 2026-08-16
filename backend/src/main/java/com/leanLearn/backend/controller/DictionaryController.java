package com.leanLearn.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    /**
     * Get the translation for a Finnish word.
     * 
     * @param word the Finnish word to translate
     * @throws InterruptedException
     * @throws IOException
     */
    @GetMapping
    String getTranslationForEN(String word) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://freedictionaryapi.com/api/v1/entries/en/" + word))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        // response.body().stream().forEach(System.out::println);

        System.out.println(response.body());
        return response.body();
    }

    /**
     * Get the translation for a German word.
     *
     * @param word the German word to translate
     */
    void getTranslationForDE(String word) {
        // Implement the logic to call the external API and retrieve the translation
    }

}
