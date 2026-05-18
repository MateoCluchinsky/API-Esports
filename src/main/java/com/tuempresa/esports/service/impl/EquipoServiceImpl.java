package com.tuempresa.esports.service.impl;

import com.tuempresa.esports.dto.EquipoDTO;
import com.tuempresa.esports.mapper.EquipoMapper;
import com.tuempresa.esports.model.Equipo;
import com.tuempresa.esports.repository.EquipoRepository;
import com.tuempresa.esports.service.EquipoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository equipoRepository;
    private final EquipoMapper equipoMapper;

    // Inyección de dependencias por constructor
    public EquipoServiceImpl(EquipoRepository equipoRepository, EquipoMapper equipoMapper) {
        this.equipoRepository = equipoRepository;
        this.equipoMapper = equipoMapper;
    }

    @Override
    public EquipoDTO guardar(EquipoDTO equipoDTO) {
        Equipo equipo = equipoMapper.toEntity(equipoDTO);
        Equipo equipoGuardado = equipoRepository.save(equipo);
        return equipoMapper.toDTO(equipoGuardado);
    }

    @Override
    public List<EquipoDTO> listarTodos() {
        return equipoRepository.findAll().stream()
                .map(equipoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EquipoDTO buscarPorId(Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        return equipoMapper.toDTO(equipo);
    }

    @Override
    public EquipoDTO actualizar(Long id, EquipoDTO equipoDTO) {
        Equipo equipoExistente = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));

        // Actualizamos los datos
        equipoExistente.setNombre(equipoDTO.getNombre());
        equipoExistente.setCopas(equipoDTO.getCopas());

        Equipo equipoActualizado = equipoRepository.save(equipoExistente);
        return equipoMapper.toDTO(equipoActualizado);
    }

    @Override
    public void eliminar(Long id) {
        equipoRepository.deleteById(id);
    }
}