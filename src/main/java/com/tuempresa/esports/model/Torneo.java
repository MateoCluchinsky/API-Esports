package com.tuempresa.esports.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double premio;

    // Relación ManyToMany (Inversa): Un torneo tiene muchos equipos inscriptos
    @ManyToMany(mappedBy = "torneos")
    private List<Equipo> equipos;
}