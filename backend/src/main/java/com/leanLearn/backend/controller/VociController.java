package com.leanLearn.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.leanLearn.backend.services.VociService;
import com.leanLearn.backend.model.Voci;
import com.leanLearn.backend.model.VociDTO;
import com.leanLearn.backend.model.VociRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/voci")
@Tag(name = "Voci", description = "Endpoints for managing vocabulary words")
public class VociController {

    private final VociService vociService;

    public VociController(VociService vociService) {
        this.vociService = vociService;
    }

    @GetMapping
    @Operation(summary = "Get all words", description = "Returns the full list of vocabulary words", responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved word list", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = VociDTO.class))))
    })
    public ResponseEntity<List<VociDTO>> getAllWords() {

        List<VociDTO> vociList = vociService.getAllWords().stream().map(voci -> new VociDTO(voci, vociService))
                .collect(Collectors.toList());

        return ResponseEntity.ok(vociList);
    }

    @PostMapping
    @Operation(summary = "Add a new word", description = "Adds a new vocabulary word to the list", responses = {
            @ApiResponse(responseCode = "200", description = "Successfully added the word", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public String addWord(@Valid @RequestBody VociRequest entity) {
        Voci savedVoci = vociService.addWord(entity);
        return savedVoci.getId();
    }

    @PutMapping("/bump/{id}")
    public ResponseEntity<Void> bumpWord(@PathVariable String id) {
        vociService.bumpWord(id);
        return ResponseEntity.ok().build();
    }
}
