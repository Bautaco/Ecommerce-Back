package com.example.pa.controller;


import com.example.pa.model.EstadisticaCliente;
import com.example.pa.service.EstadisticaClienteService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticaClienteController {

    @Autowired
    private EstadisticaClienteService estadisticaClienteService;

    @GetMapping("/cliente")
    public ResponseEntity<List<EstadisticaCliente>> obtenerEstadisticasCliente(
            @RequestParam("userId") Long userId,
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {

        List<EstadisticaCliente> estadisticas = estadisticaClienteService.findByUserAndFechaCompraBetween(userId, fechaInicio, fechaFin);
        return ResponseEntity.ok(estadisticas);
    }
}
