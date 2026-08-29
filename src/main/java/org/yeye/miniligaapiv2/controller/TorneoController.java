package org.yeye.miniligaapiv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/crear-fase-grupos/{id}")
    public void crearFaseDeGrupos(@PathVariable Long id) {
        torneoService.crearFaseDeGrupos(id);
    }

    @PostMapping("/{id}/cuartos")
    public void crearCuartosDeFinal(@PathVariable Long id) {
        torneoService.crearCuartosDeFinal(id);
    }

    @PostMapping("/{id}/semifinal")
    public void crearSemifinal(@PathVariable Long id) {
        torneoService.crearSemifinal(id);
    }

}
