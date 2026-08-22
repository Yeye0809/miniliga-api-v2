package org.yeye.miniligaapiv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeye.miniligaapiv2.dto.PartidoDto;
import org.yeye.miniligaapiv2.entity.Equipo;
import org.yeye.miniligaapiv2.entity.Partido;
import org.yeye.miniligaapiv2.entity.Torneo;
import org.yeye.miniligaapiv2.mapper.PartidoMapper;
import org.yeye.miniligaapiv2.repository.EquipoRepository;
import org.yeye.miniligaapiv2.repository.PartidoRepository;
import org.yeye.miniligaapiv2.repository.TorneoRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PartidoServiceImpl implements PartidoService {
    @Autowired
    PartidoRepository partidoRepository;
    @Autowired
    EquipoRepository equipoRepository;
    @Autowired
    TorneoRepository torneoRepository;

    @Override
    public List<PartidoDto> generarPrimeraRonda(Long id) {
        Torneo torneo = torneoRepository.findById(id).orElseThrow(()-> new RuntimeException("torneo no encontrado"));
        List<Equipo> equipos = equipoRepository.findAll();
        List<PartidoDto> partidoDtos = new ArrayList<>();
        Collections.shuffle(equipos);

        for(int i = 0; i < equipos.size(); i += 2){
            Equipo equipoA = equipos.get(i);
            Equipo equipoB = equipos.get(i + 1);

            Partido partido = new Partido();
            partido.setEquipoA(equipoA);
            partido.setEquipoB(equipoB);
            partido.setTorneo(torneo);
            partido.setFinalizado(false);
            partidoDtos.add(PartidoMapper.toDto(partidoRepository.save(partido)));
        }
        return partidoDtos;
    }

    @Override
    public List<PartidoDto> getPartidos(Long id) {
        return partidoRepository.findByTorneoId(id).stream().map(PartidoMapper::toDto).toList();
    }
}
