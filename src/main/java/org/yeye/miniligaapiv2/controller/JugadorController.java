package org.yeye.miniligaapiv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yeye.miniligaapiv2.dto.JugadorRequestDto;
import org.yeye.miniligaapiv2.dto.JugadorResponseDto;
import org.yeye.miniligaapiv2.service.JugadorService;

import java.util.List;

@RestController
@RequestMapping("/api/jugador")
public class JugadorController {

    @Autowired
    JugadorService jugadorService;

    @PostMapping
    public ResponseEntity<JugadorResponseDto> crearJugador(@RequestBody JugadorRequestDto dto) {
        return ResponseEntity.ok(jugadorService.guardarJugador(dto));
    }

    @GetMapping
    public ResponseEntity<List<JugadorResponseDto>> obtenerJugadores() {
        return ResponseEntity.ok(jugadorService.obtenerJugadores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JugadorResponseDto> obtenerJugadorById(@PathVariable Long id) {
        return ResponseEntity.ok(jugadorService.getJugadorById(id));
    }
}
