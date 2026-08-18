package org.yeye.miniligaapiv2.mapper;

import org.yeye.miniligaapiv2.dto.EquipoResponseDto;
import org.yeye.miniligaapiv2.entity.Equipo;
import org.yeye.miniligaapiv2.entity.Torneo;

public class EquipoMapper {

    public static EquipoResponseDto toDto(Equipo equipo) {
        EquipoResponseDto dto =  EquipoResponseDto.builder()
                .id(equipo.getId())
                .nombre(equipo.getNombre())
                .torneo(equipo.getTorneo().getNombre())
                .build();

        if( equipo.getEntrenador() != null ) {
            dto.setEntrenador(equipo.getEntrenador().getNombre());
        }

        if( !equipo.getJugadores().isEmpty()) {
            dto.setJugadores(equipo.getJugadores().stream().map(JugadorMapper::toDto).toList());
        }

        return dto;
    }
}
