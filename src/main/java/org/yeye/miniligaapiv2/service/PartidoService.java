package org.yeye.miniligaapiv2.service;

import org.yeye.miniligaapiv2.dto.PartidoDto;
import org.yeye.miniligaapiv2.entity.Grupo;
import org.yeye.miniligaapiv2.entity.Partido;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface PartidoService {
    List<PartidoDto> generarPrimeraRonda(Long id);
    List<Partido> partidoFaseDeGrupos(Grupo grupo);
    List<PartidoDto> getPartidos(Long id);
    void asignarFechaPartido(Long idPartido, Map<String, LocalDateTime> fechaPartido);
    PartidoDto asignarMarcador(Long id, Map<String, Integer> marcadores);

}
