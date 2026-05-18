package com.tuempresa.esports.service;

import com.tuempresa.esports.dto.EquipoDTO;
import java.util.List;

public interface EquipoService {
    EquipoDTO guardar(EquipoDTO equipoDTO);
    List<EquipoDTO> listarTodos();
    EquipoDTO buscarPorId(Long id);
    EquipoDTO actualizar(Long id, EquipoDTO equipoDTO);
    void eliminar(Long id);
}