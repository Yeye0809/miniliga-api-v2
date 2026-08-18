package org.yeye.miniligaapiv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yeye.miniligaapiv2.dto.EntrenadorRequestDto;
import org.yeye.miniligaapiv2.dto.EntrenadorResponseDto;
import org.yeye.miniligaapiv2.service.EntrenadorService;

import java.util.List;

@RestController
@RequestMapping("/api/entrenador")
public class EntrenadorController {

    @Autowired
    EntrenadorService entrenadorService;

    @PostMapping
    public ResponseEntity<EntrenadorResponseDto> guardarEntrenador(@RequestBody EntrenadorRequestDto dto){
        return ResponseEntity.ok(entrenadorService.guardarEntrenador(dto));
    }

    @GetMapping
    public ResponseEntity<List<EntrenadorResponseDto>> listarEntrenador(){
        return ResponseEntity.ok(entrenadorService.listarEntrenador());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntrenadorResponseDto> getEntrenadorById(@PathVariable Long id){
        return ResponseEntity.ok(entrenadorService.getEntrenadorById(id));
    }
}
