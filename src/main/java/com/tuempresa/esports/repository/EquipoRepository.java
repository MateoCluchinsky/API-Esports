package com.tuempresa.esports.repository;

import com.tuempresa.esports.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}