package com.example.pa.controller;

import com.example.pa.service.EstadisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/estadisticas")
public class InformeVentaController {

    @Autowired
    private EstadisticasService estadisticasService;

    @Autowired
    public InformeVentaController(EstadisticasService estadisticasService) {
        this.estadisticasService = estadisticasService;
    }
    
    @GetMapping("/ventastotales")
    public ResponseEntity<Double> calcularVentasTotales(@RequestParam LocalDateTime fechaInicio, @RequestParam LocalDateTime fechaFin) {
        Double ventasTotales = estadisticasService.calcularVentasTotales(fechaInicio, fechaFin);
        return ResponseEntity.ok(ventasTotales);
    }

    @GetMapping("/pedidostotales")
    public ResponseEntity<Long> contarPedidos(@RequestParam LocalDateTime fechaInicio, @RequestParam LocalDateTime fechaFin) {
        Long pedidosTotales = estadisticasService.contarPedidos(fechaInicio, fechaFin);
        return ResponseEntity.ok(pedidosTotales);
    }

    @GetMapping("/productosmasvendidos")
    public ResponseEntity<List<Map<String, Object>>> obtenerProductosMasVendidos() {
        List<Map<String, Object>> productos = estadisticasService.obtenerProductosMasVendidos();
        return ResponseEntity.ok(productos);
    }
   
  
}

