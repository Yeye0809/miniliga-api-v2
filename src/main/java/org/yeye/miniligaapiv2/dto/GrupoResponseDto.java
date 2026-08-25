package org.yeye.miniligaapiv2.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrupoResponseDto {

    private Long id;
    private String nombre;
    private String torneo;
    private List<EquipoResponseDto> equipos = new ArrayList<>();
}
