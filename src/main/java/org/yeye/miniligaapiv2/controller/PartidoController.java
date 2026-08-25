package org.yeye.miniligaapiv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yeye.miniligaapiv2.dto.PartidoDto;
import org.yeye.miniligaapiv2.service.PartidoService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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

    @PatchMapping("/asignar-fecha/{id}")
    public void asignarFechaPartido(@PathVariable Long id, @RequestBody Map<String, LocalDateTime> fechaPartido){
        partidoService.asignarFechaPartido(id,fechaPartido);
    }

}
