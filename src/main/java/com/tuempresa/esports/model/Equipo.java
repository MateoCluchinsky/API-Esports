package com.tuempresa.esports.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer copas;

    // Relación ManyToOne: Este equipo le pertenece a un Manager
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    // Relación ManyToMany (Principal): Un equipo se inscribe a muchos Torneos
    @ManyToMany
    @JoinTable(
        name = "equipo_torneo",
        joinColumns = @JoinColumn(name = "equipo_id"),
        inverseJoinColumns = @JoinColumn(name = "torneo_id")
    )
    private List<Torneo> torneos;
}