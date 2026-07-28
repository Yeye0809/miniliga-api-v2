package org.yeye.miniligaapiv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yeye.miniligaapiv2.entity.Torneo;

@Repository
public interface TorneoRepository extends JpaRepository<Torneo, Long> {
}
