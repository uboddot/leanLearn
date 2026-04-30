package com.leanlearn.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leanlearn.backend.model.VociDTO;
import com.leanlearn.backend.services.VociService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/voci")
@Tag(name = "Voci", description = "Endpoints for managing vocabulary words")
public class VociController {

    @Autowired
    VociService vociService;

    @GetMapping
    @Operation(summary = "Get all words", description = "Returns the full list of vocabulary words", responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved word list", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = VociDTO.class))))
    })
    public ResponseEntity<List<VociDTO>> getAllWords() {

        List<VociDTO> vociList = vociService.getAllWords().stream().map(voci -> new VociDTO(voci))
                .collect(Collectors.toList());

        return ResponseEntity.ok(vociList);
    }

}
