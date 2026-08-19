package com.leanLearn.backend.model;

import com.leanLearn.backend.services.VociService;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Represents a vocabulary word with its translation")
public class VociDTO {

    @Schema(description = "The word in the original language", example = "casa")
    private final String original;

    @Schema(description = "The language of the original word", example = "es")
    private final String originalLanguage;

    @Schema(description = "The translated word", example = "house")
    private final String translation;

    @Schema(description = "The language of the translated word", example = "en")
    private final String translationLanguage;

    private final int vociKastenLevel;

    public VociDTO(Voci voci, VociService vociService) {
        this.original = voci.getOriginal();
        this.translation = voci.getTranslation();
        this.originalLanguage = voci.getOriginalLanguage() != null ? voci.getOriginalLanguage() : null;
        this.translationLanguage = voci.getTranslationLanguage() != null ? voci.getTranslationLanguage() : null;
        this.vociKastenLevel = vociService.getVociKasten(voci) != null ? vociService.getVociKasten(voci).getLevel() : 0;
    }

    public String getOriginal() {
        return original;
    }

    public String getTranslation() {
        return translation;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getTranslationLanguage() {
        return translationLanguage;
    }

    public int getVociKastenLevel() {
        return vociKastenLevel;
    }
}
