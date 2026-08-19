package com.leanLearn.backend.model;

public record VociKastenDTO(String id, int level) {

    public VociKastenDTO(VociKasten vociKasten) {
        this(vociKasten.getId(), vociKasten.getLevel());
    }

}
