package org.yeye.miniligaapiv2.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntrenadorResponseDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String nombreEquipo;
}
