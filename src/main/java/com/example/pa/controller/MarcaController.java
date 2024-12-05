package com.example.pa.controller;

import com.example.pa.controller.DTO.MarcaDTO.MarcaDTO;
import com.example.pa.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    // Crear una nueva marca
    @PostMapping
    public ResponseEntity<MarcaDTO> crearMarca(@RequestBody MarcaDTO marcaDTO) {
        MarcaDTO nuevaMarca = marcaService.crearMarca(marcaDTO);
        return new ResponseEntity<>(nuevaMarca, HttpStatus.CREATED);
    }

    // Actualizar una marca existente
     @PutMapping("/{id}")
    public ResponseEntity<MarcaDTO> actualizarMarca(@PathVariable Long id, @RequestBody MarcaDTO marcaDTO) {
        MarcaDTO marcaActualizada = marcaService.actualizarMarca(id, marcaDTO);
        return marcaActualizada != null
            ? new ResponseEntity<>(marcaActualizada, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Eliminar una marca (cambio de estado)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMarca(@PathVariable Long id) {
        marcaService.eliminarMarca(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Obtener todas las marcas activas
    @GetMapping
    public ResponseEntity<List<MarcaDTO>> obtenerMarcas() {
        List<MarcaDTO> marcas = marcaService.obtenerMarcas();
        return new ResponseEntity<>(marcas, HttpStatus.OK);
    }

}
