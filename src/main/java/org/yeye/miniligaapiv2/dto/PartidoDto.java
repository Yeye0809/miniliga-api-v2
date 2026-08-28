package org.yeye.miniligaapiv2.dto;

import lombok.*;
import org.yeye.miniligaapiv2.enums.FasePartido;

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
    private FasePartido fase;
    private LocalDateTime fecha;
}
