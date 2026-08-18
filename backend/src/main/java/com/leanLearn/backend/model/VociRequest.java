package com.leanLearn.backend.model;

import jakarta.validation.constraints.NotBlank;

/**
 * VociRequest
 */
public record VociRequest(@NotBlank String original, String originalLanguage, @NotBlank String translation,
        String translationLanguage) {
}
