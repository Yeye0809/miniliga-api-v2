package org.yeye.miniligaapiv2.mapper;

import org.yeye.miniligaapiv2.dto.EntrenadorResponseDto;
import org.yeye.miniligaapiv2.entity.Entrenador;


public class EntrenadorMapper {

    public static EntrenadorResponseDto toDto(Entrenador entrenador) {
            EntrenadorResponseDto dto = EntrenadorResponseDto.builder()
                    .id(entrenador.getId())
                    .nombre(entrenador.getNombre())
                    .apellido(entrenador.getApellido())
                    .telefono(entrenador.getTelefono())
                    .build();

            if( entrenador.getEquipo() != null ) {
                dto.setNombreEquipo(entrenador.getEquipo().getNombre());
            }

            return dto;
    }
}
