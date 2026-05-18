package com.tuempresa.esports.repository;

import com.tuempresa.esports.model.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TorneoRepository extends JpaRepository<Torneo, Long> {
}