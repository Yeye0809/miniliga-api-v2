package org.yeye.miniligaapiv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeye.miniligaapiv2.dto.JugadorRequestDto;
import org.yeye.miniligaapiv2.dto.JugadorResponseDto;
import org.yeye.miniligaapiv2.entity.Equipo;
import org.yeye.miniligaapiv2.entity.Jugador;
import org.yeye.miniligaapiv2.mapper.JugadorMapper;
import org.yeye.miniligaapiv2.repository.EquipoRepository;
import org.yeye.miniligaapiv2.repository.JugadorRepository;

import java.util.List;

@Service
public class JugadorServiceImpl implements  JugadorService {

    @Autowired
    JugadorRepository jugadorRepository;

    @Autowired
    EquipoRepository equipoRepository;

    @Override
    public JugadorResponseDto guardarJugador(JugadorRequestDto dto){

        Jugador jugador = Jugador.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .telefono(dto.getTelefono())
                .posicion(dto.getPosicion().toUpperCase())
                .build();
        if( dto.getEquipo() != null ) {
            Equipo equipo = equipoRepository.findById(dto.getEquipo()).orElseThrow(() -> new RuntimeException("equipo no encontrado"));
            jugador.setEquipo(equipo);
        }else{
            throw new RuntimeException("Debe asignar un equipo");
        }

        return JugadorMapper.toDto(jugadorRepository.save(jugador));

    }

    @Override
    public List<JugadorResponseDto> obtenerJugadores(){
        return jugadorRepository.findAll().stream().map(JugadorMapper::toDto).toList();
    }

    @Override
    public JugadorResponseDto getJugadorById(Long id){
        return jugadorRepository.findById(id).map(JugadorMapper::toDto).orElseThrow(()-> new RuntimeException("Jugador no encontrado"));
    }
}
