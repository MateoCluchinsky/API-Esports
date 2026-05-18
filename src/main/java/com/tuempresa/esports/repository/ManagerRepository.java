package com.tuempresa.esports.repository;

import com.tuempresa.esports.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    // Este método personalizado se va a utilizar después en el login
    Optional<Manager> findByUsername(String username);
}