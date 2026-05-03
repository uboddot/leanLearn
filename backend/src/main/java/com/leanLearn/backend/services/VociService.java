package com.leanlearn.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.leanlearn.backend.model.Voci;

@Service
public class VociService {
    public List<Voci> getAllWords() {
        List<Voci> voci = new ArrayList<>();
        voci.add(new Voci("danke", "kiitos"));
        voci.add(new Voci("ich", "minä"));

        return voci;
    }
}
