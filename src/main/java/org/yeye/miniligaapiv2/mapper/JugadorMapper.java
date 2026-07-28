package org.yeye.miniligaapiv2.mapper;

import org.yeye.miniligaapiv2.dto.JugadorResponseDto;
import org.yeye.miniligaapiv2.entity.Jugador;

public class JugadorMapper {

    public static JugadorResponseDto toDto(Jugador jugador) {
        return JugadorResponseDto.builder()
                .id(jugador.getId())
                .nombre(jugador.getNombre())
                .apellido(jugador.getApellido())
                .posicion(jugador.getPosicion().name())
                .telefono(jugador.getTelefono())
                .equipo(jugador.getEquipo().getNombre())
                .build();
    }
}
