package com.example.pa.controller;

import com.example.pa.controller.DTO.EstadisticaDTO.EstadisticaClienteDTO;
import com.example.pa.service.EstadisticaClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticaClienteController {

    @Autowired
    private EstadisticaClienteService EstadisticaClienteService;

    @GetMapping("/cliente/{clienteId}")
    public EstadisticaClienteDTO obtenerEstadisticasCliente(@PathVariable Long clienteId) {
        return EstadisticaClienteService.obtenerEstadisticasCliente(clienteId);
    }
}
