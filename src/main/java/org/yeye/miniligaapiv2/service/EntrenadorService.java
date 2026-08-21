package org.yeye.miniligaapiv2.service;

import org.yeye.miniligaapiv2.dto.EntrenadorRequestDto;
import org.yeye.miniligaapiv2.dto.EntrenadorResponseDto;

import java.util.List;
import java.util.Map;

public interface EntrenadorService {

     EntrenadorResponseDto guardarEntrenador(EntrenadorRequestDto dto);
     List<EntrenadorResponseDto> listarEntrenador();
     EntrenadorResponseDto getEntrenadorById(Long id);
     EntrenadorResponseDto actualizarEntrenador(Long id, Map<String, Object> params);

}
