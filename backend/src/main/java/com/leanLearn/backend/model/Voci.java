package com.leanLearn.backend.model;

import com.leanLearn.backend.model.VociKasten;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.leanLearn.backend.services.VociService;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "voci")
@NoArgsConstructor
@Getter
@Setter
public class Voci {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String original;
    private String originalLanguage;
    private String translation;
    private String translationLanguage;

    private LocalDateTime createdAt;

    private String vociKastenId;

    public Voci(String original, String originalLanguage, String translation, String translationLanguage) {
        this.original = original;
        this.originalLanguage = originalLanguage;
        this.translation = translation;
        this.translationLanguage = translationLanguage;
        this.createdAt = java.time.LocalDateTime.now();
    }

    public Voci(String original, String translation) {
        this.original = original;
        this.translation = translation;
        this.createdAt = java.time.LocalDateTime.now();
    }

}
