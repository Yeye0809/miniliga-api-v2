package org.yeye.miniligaapiv2.mapper;

import org.yeye.miniligaapiv2.dto.PartidoDto;
import org.yeye.miniligaapiv2.entity.Partido;

public class PartidoMapper {

    public static PartidoDto toDto(Partido partido) {
        PartidoDto dto = PartidoDto.builder()
                .equipoA(partido.getEquipoA().getNombre())
                .equipoB(partido.getEquipoB().getNombre())
                .finalizado(partido.getFinalizado())
                .fase(partido.getFase())
                .build();

        if(partido.getFecha() != null)
            dto.setFecha(partido.getFecha());

        return dto;
    }
}
