package org.yeye.miniligaapiv2.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeye.miniligaapiv2.dto.TorneoRequestDto;
import org.yeye.miniligaapiv2.dto.TorneoResponseDto;
import org.yeye.miniligaapiv2.entity.Equipo;
import org.yeye.miniligaapiv2.entity.Grupo;
import org.yeye.miniligaapiv2.entity.Partido;
import org.yeye.miniligaapiv2.entity.Torneo;
import org.yeye.miniligaapiv2.mapper.TorneoMapper;
import org.yeye.miniligaapiv2.repository.GrupoRepository;
import org.yeye.miniligaapiv2.repository.PartidoRepository;
import org.yeye.miniligaapiv2.repository.TorneoRepository;

import java.util.Collections;
import java.util.List;

@Service
public class TorneoServiceImpl implements TorneoService{

    @Autowired
    private TorneoRepository torneoRepository;
    @Autowired
    private PartidoService  partidoService;
    @Autowired
    PartidoRepository partidoRepository;
    @Autowired
    private GrupoRepository grupoRepository;


    @Override
    public TorneoResponseDto crearTorneo(TorneoRequestDto dto){
        Torneo torneo = new Torneo();
        torneo.setNombre(dto.getNombre());
        torneo.setDescripcion(dto.getDescripcion());
        torneo.setFechaInicio(dto.getFechaInicio());
        torneo.setFechaFin(dto.getFechaFin());
        torneo.setActivo(true);

        return TorneoMapper.toDto(torneoRepository.save(torneo));

    }

    @Transactional
    @Override
    public void crearFaseDeGrupos(Long idTorneo) {
        Torneo torneo = torneoRepository.findById(idTorneo).orElseThrow(()-> new RuntimeException("torneo no encontrado"));
        List<Equipo> equipos = torneo.getEquipos();

        if( equipos.size() != 16 )
            throw new RuntimeException("El torneo debe tener 16 equipos");

        Collections.shuffle(equipos);

        for( int i = 0; i < 4;i++ ) {
            Grupo  grupo = new Grupo();
            grupo.setNombre("Grupo " + (char)('A' + i));
            grupo.setTorneo(torneo);

            for( int j = 0; j < 4; j++){
                Equipo equipo = equipos.get( i * 4 + j );
                grupo.getEquipos().add(equipo);
            }

            grupoRepository.save(grupo);
            List<Partido> partidos = partidoService.partidoFaseDeGrupos(grupo);
            partidoRepository.saveAll(partidos);

        }
    }

}
