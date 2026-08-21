package org.yeye.miniligaapiv2.service;

import org.yeye.miniligaapiv2.dto.EquipoRequestDto;
import org.yeye.miniligaapiv2.dto.EquipoResponseDto;

import java.util.List;
import java.util.Map;

public interface EquipoService {

    EquipoResponseDto crearEquipo(EquipoRequestDto dto);
    List<EquipoResponseDto> listarEquipos();
    EquipoResponseDto getEquipoById(Long id);
    EquipoResponseDto actualizarEquipo(Long id, Map<String, Object> params);

}
