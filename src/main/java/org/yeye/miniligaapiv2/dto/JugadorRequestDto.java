package org.yeye.miniligaapiv2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JugadorRequestDto {

    private String nombre;
    private String apellido;
    private String telefono;
    private String posicion;
    private Long equipo;

}
