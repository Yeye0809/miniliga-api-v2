package org.yeye.miniligaapiv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yeye.miniligaapiv2.dto.TorneoRequestDto;
import org.yeye.miniligaapiv2.dto.TorneoResponseDto;
import org.yeye.miniligaapiv2.service.TorneoService;

@RestController
@RequestMapping("/api/torneo")
public class TorneoController {

    @Autowired
    TorneoService torneoService;

    @PostMapping
    public ResponseEntity<TorneoResponseDto> crearTorneo(@RequestBody TorneoRequestDto dto) {
        return ResponseEntity.ok(torneoService.crearTorneo(dto));
    }
}
