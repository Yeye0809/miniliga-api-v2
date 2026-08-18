package org.yeye.miniligaapiv2.dto;

import lombok.*;
import org.yeye.miniligaapiv2.entity.Torneo;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipoResponseDto {
    private Long id;
    private String nombre;
    private String torneo;
    private String entrenador;
    private List<JugadorResponseDto>  jugadores;
}
