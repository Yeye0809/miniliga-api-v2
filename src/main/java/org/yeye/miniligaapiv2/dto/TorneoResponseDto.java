package org.yeye.miniligaapiv2.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TorneoResponseDto {

    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
//    private List<Equipo> equipos;
//    private List<Partido> partidos;
//    private List<EstadisticaJugador> estadisticaJugadores;
    private Boolean activo;

}
