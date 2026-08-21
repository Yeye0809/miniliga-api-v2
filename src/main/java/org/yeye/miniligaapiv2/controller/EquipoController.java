package org.yeye.miniligaapiv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yeye.miniligaapiv2.dto.EquipoRequestDto;
import org.yeye.miniligaapiv2.dto.EquipoResponseDto;
import org.yeye.miniligaapiv2.service.EquipoService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {

    @Autowired
    EquipoService equipoService;

    @PostMapping
    public ResponseEntity<EquipoResponseDto> crearEquipo(@RequestBody EquipoRequestDto dto) {
        return ResponseEntity.ok(equipoService.crearEquipo(dto));
    }

    @GetMapping
    public ResponseEntity<List<EquipoResponseDto>> listarEquipos(){
        return ResponseEntity.ok(equipoService.listarEquipos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoResponseDto> getEquipoById(@PathVariable Long id){
        return ResponseEntity.ok(equipoService.getEquipoById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EquipoResponseDto> actualizar(@PathVariable Long id, @RequestBody Map<String, Object> params){
        return ResponseEntity.ok(equipoService.actualizarEquipo(id, params));
    }
}
