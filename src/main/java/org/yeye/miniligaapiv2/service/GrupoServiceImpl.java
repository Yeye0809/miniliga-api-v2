package org.yeye.miniligaapiv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeye.miniligaapiv2.dto.GrupoResponseDto;
import org.yeye.miniligaapiv2.mapper.GrupoMapper;
import org.yeye.miniligaapiv2.repository.GrupoRepository;

import java.util.List;

@Service
public class GrupoServiceImpl implements GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Override
    public List<GrupoResponseDto> getGrupos(Long torneoId) {
       return grupoRepository.findByTorneoId(torneoId).stream().map(GrupoMapper::toDto).toList();
    }
}
