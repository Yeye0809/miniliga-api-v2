package org.yeye.miniligaapiv2.service;

import org.yeye.miniligaapiv2.dto.TorneoRequestDto;
import org.yeye.miniligaapiv2.dto.TorneoResponseDto;
import org.yeye.miniligaapiv2.entity.Torneo;

public interface TorneoService {

    TorneoResponseDto crearTorneo(TorneoRequestDto dto);
    void crearFaseDeGrupos(Long IdTorneo);
}
