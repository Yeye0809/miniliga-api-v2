package org.yeye.miniligaapiv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeye.miniligaapiv2.dto.TorneoRequestDto;
import org.yeye.miniligaapiv2.dto.TorneoResponseDto;
import org.yeye.miniligaapiv2.entity.Torneo;
import org.yeye.miniligaapiv2.mapper.TorneoMapper;
import org.yeye.miniligaapiv2.repository.TorneoRepository;

@Service
public class TorneoServiceImpl implements TorneoService{

    @Autowired
    private TorneoRepository torneoRepository;

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
}
