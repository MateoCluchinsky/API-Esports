package com.tuempresa.esports.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EquipoDTO {
    private Long id;

    @NotBlank(message = "El nombre del equipo es obligatorio")
    private String nombre;

    @NotNull(message = "Las copas no pueden ser nulas")
    private Integer copas;
}
