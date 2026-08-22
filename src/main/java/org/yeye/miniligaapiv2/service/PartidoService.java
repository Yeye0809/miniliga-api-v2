package org.yeye.miniligaapiv2.service;

import org.yeye.miniligaapiv2.dto.PartidoDto;

import java.util.List;

public interface PartidoService {
    List<PartidoDto> generarPrimeraRonda(Long id);
    List<PartidoDto> getPartidos(Long id);

}
