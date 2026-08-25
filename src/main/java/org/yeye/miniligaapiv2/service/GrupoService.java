package org.yeye.miniligaapiv2.service;

import org.yeye.miniligaapiv2.dto.GrupoResponseDto;

import java.util.List;

public interface GrupoService {
    List<GrupoResponseDto> getGrupos(Long torneoId);

}
