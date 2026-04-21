package com.leanlearn.backend.model;

public class VociDTO {
    public String original;
    public String translation;

    public VociDTO(Voci word) {
        this.original = word.getOriginal();
        this.translation = word.getTranslation();
    }
}
