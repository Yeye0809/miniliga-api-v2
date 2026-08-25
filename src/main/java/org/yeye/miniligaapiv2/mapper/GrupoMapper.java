package org.yeye.miniligaapiv2.mapper;

import org.yeye.miniligaapiv2.dto.EquipoResponseDto;
import org.yeye.miniligaapiv2.dto.GrupoResponseDto;
import org.yeye.miniligaapiv2.entity.Grupo;

import java.util.ArrayList;
import java.util.List;

public class GrupoMapper {

    public static GrupoResponseDto toDto(Grupo grupo) {
        GrupoResponseDto dto = GrupoResponseDto.builder()
                .id(grupo.getId())
                .nombre(grupo.getNombre())
                .torneo(grupo.getTorneo().getNombre())
                .build();

        dto.setEquipos((grupo.getEquipos().stream().map(EquipoMapper::toDto)).toList());

        return dto;
    }
}
