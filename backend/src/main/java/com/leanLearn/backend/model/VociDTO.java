package com.leanlearn.backend.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Represents a vocabulary word with its translation")
public class VociDTO {

    @Schema(description = "The word in the original language", example = "casa")
    public String original;

    @Schema(description = "The translated word", example = "house")
    public String translation;

    public VociDTO(Voci word) {
        this.original = word.getOriginal();
        this.translation = word.getTranslation();
    }
}
