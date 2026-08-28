package org.yeye.miniligaapiv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yeye.miniligaapiv2.dto.PartidoDto;
import org.yeye.miniligaapiv2.entity.Partido;
import org.yeye.miniligaapiv2.enums.FasePartido;

import java.util.List;
import java.util.Map;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
    List<Partido> findByTorneoId(Long torneoId);
    List<Partido> findByGrupoId(Long grupoId);
    List<Partido> findByTorneoIdAndFase(Long torneoId, FasePartido fase);
}
