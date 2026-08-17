package com.leanLearn.backend.controller;

import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class DictionaryClient {

    private final RestClient restClient;

    public DictionaryClient() {
        var http = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(2)).build();
        var factory = new JdkClientHttpRequestFactory(http);
        factory.setReadTimeout(Duration.ofSeconds(2));
        this.restClient = RestClient.builder()
                .baseUrl("https://freedictionaryapi.com/api/v1")
                .requestFactory(factory)
                .build();
    }

    /** All translations of {word} (looked up as {sourceLang}) into {targetLang}. */
    public List<String> translate(String word, String sourceLang, String targetLang) {
        DictionaryResponse response;
        try {
            response = restClient.get()
                    .uri(b -> b.path("/entries/{language}/{word}")
                            .queryParam("translations", true) // step 1
                            .build(sourceLang, word))
                    .retrieve()
                    .body(DictionaryResponse.class); // step 2
        } catch (HttpClientErrorException.NotFound e) {
            return List.of(); // word not in dictionary
        }
        if (response == null)
            return List.of();

        return response.entries().stream()
                .flatMap(e -> flattenSenses(e.senses())) // step 3
                .flatMap(s -> s.translations().stream()) // step 4
                .filter(t -> t.language() != null && targetLang.equals(t.language().code()))
                .map(Translation::word)
                .filter(Objects::nonNull)
                .distinct()
                .toList();
    }

    /** Every sense including nested subsenses, flattened depth-first. */
    private static Stream<Sense> flattenSenses(List<Sense> senses) {
        return senses.stream()
                .flatMap(s -> Stream.concat(Stream.of(s), flattenSenses(s.subsenses())));
    }

}
