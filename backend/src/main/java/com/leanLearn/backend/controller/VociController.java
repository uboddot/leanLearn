package com.leanlearn.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leanlearn.backend.model.Voci;
import com.leanlearn.backend.model.VociDTO;
import com.leanlearn.backend.services.VociService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/voci")
public class VociController {

    @Autowired
    VociService vociService;

    @GetMapping
    public ResponseEntity<List<VociDTO>> getAllWords() {

        List<VociDTO> vociList = vociService.getAllWords().stream().map(voci -> new VociDTO(voci))
                .collect(Collectors.toList());

        return ResponseEntity.ok(vociList);
    }

}
