package org.yeye.miniligaapiv2.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartidoDto {
    private String equipoA;
    private String equipoB;
    private Boolean finalizado;
    private LocalDate fecha;
}
