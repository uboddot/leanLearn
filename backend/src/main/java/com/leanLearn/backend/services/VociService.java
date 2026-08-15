package com.leanLearn.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leanLearn.backend.model.Voci;
import com.leanLearn.backend.repository.VociRepository;

@Service
public class VociService {

    private final VociRepository vociRepository;

    public VociService(VociRepository vociRepository) {
        this.vociRepository = vociRepository;
    }

    public List<Voci> getAllWords() {
        return vociRepository.findAll();
    }
}
