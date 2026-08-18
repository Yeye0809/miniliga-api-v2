package org.yeye.miniligaapiv2.service;

import org.yeye.miniligaapiv2.dto.JugadorRequestDto;
import org.yeye.miniligaapiv2.dto.JugadorResponseDto;

import java.util.List;

public interface JugadorService {
    JugadorResponseDto guardarJugador(JugadorRequestDto dto);
    List<JugadorResponseDto> obtenerJugadores();
    JugadorResponseDto getJugadorById(Long id);
}
