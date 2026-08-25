package org.yeye.miniligaapiv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yeye.miniligaapiv2.dto.GrupoResponseDto;
import org.yeye.miniligaapiv2.service.GrupoService;

import java.util.List;

@RestController
@RequestMapping("/api/grupo")
public class GrupoController {

    @Autowired
    GrupoService grupoService;

    @GetMapping("/{id}")
    public ResponseEntity<List<GrupoResponseDto>> obtenerGrupos(@PathVariable Long id) {
        return ResponseEntity.ok(grupoService.getGrupos(id));
    }
}
