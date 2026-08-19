package com.leanLearn.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leanLearn.backend.model.VociKastenDTO;
import com.leanLearn.backend.repository.VociKastenRepository;

import java.util.List;

@RestController
@RequestMapping("/api/voci-kasten")
public class VociKastenController {

    private final VociKastenRepository vociKastenRepository;

    public VociKastenController(VociKastenRepository vociKastenRepository) {
        this.vociKastenRepository = vociKastenRepository;
    }

    @GetMapping
    public List<VociKastenDTO> getAllVociKasten() {
        return vociKastenRepository.findAll()
                .stream()
                .map(VociKastenDTO::new)
                .toList();
    }

}
