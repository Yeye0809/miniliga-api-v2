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
        //apuntamos a todos los equipos del torneo
        List<Equipo> equipos = torneo.getEquipos();

        //se valida que la cantidad de equipos sea 16
        if( equipos.size() != 16 )
            throw new RuntimeException("El torneo debe tener 16 equipos");

        //se mezclan los equipos
        Collections.shuffle(equipos);

        //con el siguiente ciclo se crean los grupos (16 equipos, se crean 4 grupos de 4 equipos cada uno)
        for( int i = 0; i < 4;i++ ) {
            Grupo  grupo = new Grupo();
            // las comiilas simples indican que es un tipo de dato char, los char manejan un valor numerico el internamente que nos permite
            // realizar operaciones matematicas, aqui le indicamos que al valor numerico de 'A' se le va a sumar i, para que vaya aumentando
            // y asi ir avanzando en orden alfabetico, despues de esa operacion convertimos ese valor numerico en un atributo char
            // el cual nos da la letra que va a tener el grupo
            grupo.setNombre("Grupo " + (char)('A' + i));
            grupo.setTorneo(torneo);

            // como cada grupo va a tener 4 equipos, indicamos que el ciclo va a tener un maximo de 4 iteraciones
            for( int j = 0; j < 4; j++){
                // Calcula la posición del equipo en la lista según el grupo (i) y su posición dentro del ciclo (j).
                // i = 0 (grupo A), 0 * 4 + j(0) = 0; 0 * 4 + j(1) = 1, 0 * 4 + j(2) = 2; 0 * 4 + j(3) = 3
                // i = 1 (grupo B), 1 * 4 + j(0) = 4; 1 * 4 + j(1) = 5, 1 * 4 + j(2) = 6, 1 * 4 + j(3) = 7....
                Equipo equipo = equipos.get( i * 4 + j );

                //se guarda el equipo en la lista de cada grupo
                grupo.getEquipos().add(equipo);
            }

            //guarda el grupo en la base de datos
            grupoRepository.save(grupo);
            List<Partido> partidos = partidoService.partidoFaseDeGrupos(grupo);
            // guarda todos los partidos en la base de datos
            partidoRepository.saveAll(partidos);

        }
    }

}
