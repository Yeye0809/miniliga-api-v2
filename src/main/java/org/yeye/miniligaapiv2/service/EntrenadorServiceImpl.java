package org.yeye.miniligaapiv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeye.miniligaapiv2.dto.EntrenadorRequestDto;
import org.yeye.miniligaapiv2.dto.EntrenadorResponseDto;
import org.yeye.miniligaapiv2.entity.Entrenador;
import org.yeye.miniligaapiv2.mapper.EntrenadorMapper;
import org.yeye.miniligaapiv2.repository.EntrenadorRepository;

import java.util.List;
import java.util.Map;

@Service
public class EntrenadorServiceImpl implements EntrenadorService {

    @Autowired
    EntrenadorRepository entrenadorRepository;

    @Override
    public EntrenadorResponseDto guardarEntrenador(EntrenadorRequestDto dto){
        Entrenador entrenador = Entrenador.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .telefono(dto.getTelefono())
                .build();

        return EntrenadorMapper.toDto(entrenadorRepository.save(entrenador));
    }

    @Override
    public List<EntrenadorResponseDto> listarEntrenador(){
        List<EntrenadorResponseDto> lista = entrenadorRepository.findAll().stream().map(EntrenadorMapper::toDto).toList();
        return lista;
    }

    @Override
    public EntrenadorResponseDto getEntrenadorById(Long id){
        return entrenadorRepository.findById(id).map(EntrenadorMapper::toDto).orElseThrow(()-> new RuntimeException("Entrenador not found!"));
    }

    @Override
    public EntrenadorResponseDto actualizarEntrenador(Long id, Map<String, Object> params){
        Entrenador entrenador = entrenadorRepository.findById(id).orElseThrow(()-> new RuntimeException("Entrenador not found!"));

        if( params.containsKey("nombre")){
            entrenador.setNombre(params.get("nombre").toString());
        }

        if( params.containsKey("apellido")){
            entrenador.setApellido(params.get("apellido").toString());
        }

        if( params.containsKey("telefono")){
            entrenador.setTelefono(params.get("telefono").toString());
        }

        Entrenador actualizado = entrenadorRepository.save(entrenador);
        return EntrenadorMapper.toDto(actualizado);
    }

}
