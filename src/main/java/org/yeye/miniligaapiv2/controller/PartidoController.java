package org.yeye.miniligaapiv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yeye.miniligaapiv2.dto.PartidoDto;
import org.yeye.miniligaapiv2.service.PartidoService;

import java.util.List;

@RestController
@RequestMapping("/api/partido")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @PostMapping("/generar-jornada/{id}")
    public ResponseEntity<List<PartidoDto>> primeraRonda(@PathVariable Long id){
        return  ResponseEntity.ok(partidoService.generarPrimeraRonda(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PartidoDto>> getPartidos(@PathVariable Long id){
        return ResponseEntity.ok(partidoService.getPartidos(id));
    }

}
