package com.tuempresa.esports.service;

import com.tuempresa.esports.dto.EquipoDTO;
import com.tuempresa.esports.mapper.EquipoMapper;
import com.tuempresa.esports.model.Equipo;
import com.tuempresa.esports.repository.EquipoRepository;
import com.tuempresa.esports.service.impl.EquipoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EquipoServiceTest {

    @Mock
    private EquipoRepository equipoRepository;

    @Mock
    private EquipoMapper equipoMapper;

    @InjectMocks
    private EquipoServiceImpl equipoService;

    @BeforeEach
    void setUp() {
        // Preparamos los simuladores (Mocks)
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarPorId_CuandoEquipoExiste_RetornaEquipoDTO() {
        // 1. Preparación (Arrange)
        Long idPrueba = 1L;
        
        Equipo equipoSimulado = new Equipo();
        equipoSimulado.setId(idPrueba);
        equipoSimulado.setNombre("Team Queso");

        EquipoDTO dtoSimulado = new EquipoDTO();
        dtoSimulado.setId(idPrueba);
        dtoSimulado.setNombre("Team Queso");

        when(equipoRepository.findById(idPrueba)).thenReturn(Optional.of(equipoSimulado));
        when(equipoMapper.toDTO(equipoSimulado)).thenReturn(dtoSimulado);

        // 2. Ejecución (Act)
        EquipoDTO resultado = equipoService.buscarPorId(idPrueba);

        // 3. Verificación (Assert)
        assertNotNull(resultado, "El resultado no debería ser nulo");
        assertEquals("Team Queso", resultado.getNombre(), "El nombre del equipo no coincide");
        
        // Verificamos que el cajero (Repository) fue consultado exactamente 1 vez
        verify(equipoRepository, times(1)).findById(idPrueba);
    }
}