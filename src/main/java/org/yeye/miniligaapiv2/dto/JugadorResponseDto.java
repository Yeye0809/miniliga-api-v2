package org.yeye.miniligaapiv2.dto;

import jakarta.persistence.Entity;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JugadorResponseDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String posicion;
    private String equipo;
}
