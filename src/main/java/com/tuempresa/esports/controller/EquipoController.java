package com.tuempresa.esports.controller;

import com.tuempresa.esports.dto.EquipoDTO;
import com.tuempresa.esports.service.EquipoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    // CREATE (POST)
    @PostMapping
    public ResponseEntity<EquipoDTO> crear(@Valid @RequestBody EquipoDTO equipoDTO) {
        EquipoDTO nuevoEquipo = equipoService.guardar(equipoDTO);
        return new ResponseEntity<>(nuevoEquipo, HttpStatus.CREATED);
    }

    // READ ALL (GET)
    @GetMapping
    public ResponseEntity<List<EquipoDTO>> listarTodos() {
        return ResponseEntity.ok(equipoService.listarTodos());
    }

    // READ ONE (GET)
    @GetMapping("/{id}")
    public ResponseEntity<EquipoDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(equipoService.buscarPorId(id));
    }

    // UPDATE (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<EquipoDTO> actualizar(@PathVariable Long id, @Valid @RequestBody EquipoDTO equipoDTO) {
        return ResponseEntity.ok(equipoService.actualizar(id, equipoDTO));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        equipoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}