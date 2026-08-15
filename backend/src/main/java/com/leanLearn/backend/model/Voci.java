package com.leanLearn.backend.model;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String original;
    private String translation;

    public Voci(String original, String translation) {
        this.original = original;
        this.translation = translation;
    }
}
