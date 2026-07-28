package org.yeye.miniligaapiv2.service;

import org.yeye.miniligaapiv2.dto.TorneoRequestDto;
import org.yeye.miniligaapiv2.dto.TorneoResponseDto;

public interface TorneoService {

    TorneoResponseDto crearTorneo(TorneoRequestDto dto);
}
