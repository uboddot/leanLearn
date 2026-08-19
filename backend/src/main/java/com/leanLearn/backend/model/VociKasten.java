package com.leanLearn.backend.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "voci_kasten")
public class VociKasten {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private int level;

    public VociKasten() {
    }

    public VociKasten(int level) {
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

}
