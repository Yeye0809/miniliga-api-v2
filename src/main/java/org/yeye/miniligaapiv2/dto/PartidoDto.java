package org.yeye.miniligaapiv2.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartidoDto {
    private String equipoA;
    private String equipoB;
    private Boolean finalizado;
    private LocalDateTime fecha;
}
