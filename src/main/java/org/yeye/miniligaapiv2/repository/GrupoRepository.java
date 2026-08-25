package org.yeye.miniligaapiv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yeye.miniligaapiv2.entity.Grupo;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {

    List<Grupo> findByTorneoId(long torneoId);
}
