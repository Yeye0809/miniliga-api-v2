package org.yeye.miniligaapiv2.service;

import org.yeye.miniligaapiv2.dto.JugadorRequestDto;
import org.yeye.miniligaapiv2.dto.JugadorResponseDto;

public interface JugadorService {
    JugadorResponseDto guardarJugador(JugadorRequestDto dto);
}
