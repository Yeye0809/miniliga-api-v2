package org.yeye.miniligaapiv2.service;

import org.yeye.miniligaapiv2.dto.EquipoRequestDto;
import org.yeye.miniligaapiv2.dto.EquipoResponseDto;

import java.util.List;

public interface EquipoService {

    EquipoResponseDto crearEquipo(EquipoRequestDto dto);
    List<EquipoResponseDto> listarEquipos();
    EquipoResponseDto getEquipoById(Long id);

}
