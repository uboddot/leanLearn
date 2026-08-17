package com.leanLearn.backend.controller;

import java.util.List;

record DictionaryResponse(List<Entry> entries) {
    DictionaryResponse {
        entries = entries != null ? entries : List.of();
    }
}

record Entry(List<Sense> senses) {
    Entry {
        senses = senses != null ? senses : List.of();
    }
}

record Sense(List<Translation> translations, List<Sense> subsenses) {
    Sense {
        translations = translations != null ? translations : List.of();
        subsenses = subsenses != null ? subsenses : List.of();
    }
}

record Translation(Language language, String word) {
}

record Language(String code, String name) {
}