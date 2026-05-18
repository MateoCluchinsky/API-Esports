package com.tuempresa.esports.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TorneoDTO {
    private Long id;

    @NotBlank(message = "El nombre del torneo es obligatorio")
    private String nombre;

    private Double premio;
}