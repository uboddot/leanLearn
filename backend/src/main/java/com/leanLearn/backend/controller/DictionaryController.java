package com.leanLearn.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    private final DictionaryClient dictionaryClient;

    public DictionaryController(DictionaryClient dictionaryClient) {
        this.dictionaryClient = dictionaryClient;
    }

    /**
     * Get the translation for an English word.
     * 
     * @param englishWord the English word to translate
     * @throws InterruptedException
     * @throws IOException
     */
    @GetMapping
    String getTranslationForEN(String englishWord) {

        List<String> translations = dictionaryClient.translate(englishWord, "en", "fi");
        return translations.isEmpty() ? "No translation found" : String.join(", ", translations);
    }

}
