package com.example.pa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.pa.controller.DTO.ConsultaDTO.ConsultaDTO;
import com.example.pa.model.Consulta;
import com.example.pa.model.EstadoConsulta;
import com.example.pa.service.SoporteService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/soporte/consultas")
public class SoporteController {

    @Autowired
    private SoporteService soporteService;

    // POST para crear una consulta
    @PostMapping
    public ResponseEntity<Consulta> crearConsulta(
            @RequestParam("descripcion") String descripcion,
            @RequestParam("archivos") List<MultipartFile> archivos) throws IOException {

        ConsultaDTO consultaDTO = new ConsultaDTO();
        consultaDTO.setDescripcion(descripcion);
        consultaDTO.setArchivos(archivos);

        Consulta consultaCreada = soporteService.crearConsulta(consultaDTO);
        return ResponseEntity.ok(consultaCreada);
    }

    // PUT para cambiar el estado de una consulta
    @PutMapping("/{consultaId}/estado")
    public ResponseEntity<Consulta> cambiarEstadoConsulta(
            @PathVariable Long consultaId,
            @RequestBody EstadoConsulta nuevoEstado) {

        Consulta consultaActualizada = soporteService.cambiarEstadoConsulta(consultaId, nuevoEstado);
        return ResponseEntity.ok(consultaActualizada);
    }

    // GET para obtener todas las consultas
    @GetMapping
    public ResponseEntity<List<Consulta>> obtenerTodasLasConsultas() {
        List<Consulta> consultas = soporteService.obtenerTodasLasConsultas();
        return ResponseEntity.ok(consultas);
    }
}
