package com.tuempresa.esports.mapper;

import com.tuempresa.esports.dto.EquipoDTO;
import com.tuempresa.esports.model.Equipo;
import org.springframework.stereotype.Component;

@Component
public class EquipoMapper {

    // Convierte de la Base de Datos al Escudo (Para enviar por Postman)
    public EquipoDTO toDTO(Equipo equipo) {
        if (equipo == null) return null;
        
        EquipoDTO dto = new EquipoDTO();
        dto.setId(equipo.getId());
        dto.setNombre(equipo.getNombre());
        dto.setCopas(equipo.getCopas());
        return dto;
    }

    // Convierte del Escudo a la Base de Datos (Para guardar lo que llega de Postman)
    public Equipo toEntity(EquipoDTO dto) {
        if (dto == null) return null;
        
        Equipo equipo = new Equipo();
        equipo.setId(dto.getId());
        equipo.setNombre(dto.getNombre());
        equipo.setCopas(dto.getCopas());
        return equipo;
    }
}