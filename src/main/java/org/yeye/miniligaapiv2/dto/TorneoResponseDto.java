package org.yeye.miniligaapiv2.dto;

import lombok.*;
import org.yeye.miniligaapiv2.entity.Equipo;
import org.yeye.miniligaapiv2.entity.EstadisticaJugador;
import org.yeye.miniligaapiv2.entity.Partido;

import java.time.LocalDate;
import java.util.List;

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
