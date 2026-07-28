package org.yeye.miniligaapiv2.mapper;

import org.yeye.miniligaapiv2.dto.TorneoResponseDto;
import org.yeye.miniligaapiv2.entity.Torneo;

public class TorneoMapper {

    public static TorneoResponseDto toDto(Torneo torneo) {
        return TorneoResponseDto.builder()
                .id(torneo.getId())
                .nombre(torneo.getNombre())
                .descripcion(torneo.getDescripcion())
                .fechaInicio(torneo.getFechaInicio())
                .fechaFin(torneo.getFechaFin())
                .activo(torneo.getActivo())
                .build();
    }
}
