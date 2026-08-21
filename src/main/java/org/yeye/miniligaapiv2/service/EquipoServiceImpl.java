package org.yeye.miniligaapiv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeye.miniligaapiv2.dto.EquipoRequestDto;
import org.yeye.miniligaapiv2.dto.EquipoResponseDto;
import org.yeye.miniligaapiv2.entity.Entrenador;
import org.yeye.miniligaapiv2.entity.Equipo;
import org.yeye.miniligaapiv2.entity.Torneo;
import org.yeye.miniligaapiv2.mapper.EquipoMapper;
import org.yeye.miniligaapiv2.repository.EntrenadorRepository;
import org.yeye.miniligaapiv2.repository.EquipoRepository;
import org.yeye.miniligaapiv2.repository.TorneoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EquipoServiceImpl implements EquipoService {


    @Autowired
    private EquipoRepository equipoRepository;
    @Autowired
    private TorneoRepository torneoRepository;
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Override
    public EquipoResponseDto crearEquipo(EquipoRequestDto dto){
        Equipo  equipo = new Equipo();
        equipo.setNombre(dto.getNombre());
        equipo.setJugadores(new ArrayList<>());
        if( dto.getTorneo() != null){
            Torneo torneo = torneoRepository.findById(dto.getTorneo()).orElse(null);
            equipo.setTorneo(torneo);
        }else{
            throw new RuntimeException("Debe ingresar el torneo");
        }

        return EquipoMapper.toDto(equipoRepository.save(equipo));
    }

    @Override
    public List<EquipoResponseDto> listarEquipos(){
        List<EquipoResponseDto> equipos= equipoRepository.findAll().stream().map(EquipoMapper::toDto).toList();
        return equipos;
    }

    @Override
    public EquipoResponseDto getEquipoById(Long id){
        return equipoRepository.findById(id).map(EquipoMapper::toDto).orElseThrow(()-> new RuntimeException("Error al buscar equipo"));
    }

    @Override
    public EquipoResponseDto actualizarEquipo(Long id, Map<String, Object> params){
        Equipo equipo = equipoRepository.findById(id).orElseThrow(()-> new RuntimeException("Error al actualizar equipo"));

        if( params.containsKey("nombre")){
            equipo.setNombre((String) params.get("nombre"));
        }

        if (params.containsKey("entrenador")){
            Long idEntrenador = ((Number) params.get("entrenador")).longValue();
            Entrenador entrenador = entrenadorRepository.findById(idEntrenador).orElseThrow(()-> new RuntimeException("Error al buscar entrenador"));
            equipo.setEntrenador(entrenador);
            entrenador.setEquipo(equipo);
        }

        Equipo actualizado = equipoRepository.save(equipo);

        return EquipoMapper.toDto(actualizado);
    }


}
