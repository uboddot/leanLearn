package com.leanLearn.backend.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Represents a vocabulary word with its translation")
public class VociDTO {

    @Schema(description = "The word in the original language", example = "casa")
    private final String original;

    @Schema(description = "The translated word", example = "house")
    private final String translation;

    public VociDTO(Voci voci) {
        this.original = voci.getOriginal();
        this.translation = voci.getTranslation();
    }

    public String getOriginal() {
        return original;
    }

    public String getTranslation() {
        return translation;
    }
}
