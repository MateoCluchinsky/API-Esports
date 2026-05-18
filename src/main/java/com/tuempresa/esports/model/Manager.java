package com.tuempresa.esports.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    // Relación OneToMany: Un manager puede tener varios equipos
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Equipo> equipos;
}