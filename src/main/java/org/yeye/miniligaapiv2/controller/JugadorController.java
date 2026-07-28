package org.yeye.miniligaapiv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yeye.miniligaapiv2.dto.JugadorRequestDto;
import org.yeye.miniligaapiv2.dto.JugadorResponseDto;
import org.yeye.miniligaapiv2.service.JugadorService;

@RestController
@RequestMapping("/api/jugador")
public class JugadorController {

    @Autowired
    JugadorService jugadorService;

    @PostMapping
    public ResponseEntity<JugadorResponseDto> crearJugador(@RequestBody JugadorRequestDto dto) {
        return ResponseEntity.ok(jugadorService.guardarJugador(dto));
    }
}
