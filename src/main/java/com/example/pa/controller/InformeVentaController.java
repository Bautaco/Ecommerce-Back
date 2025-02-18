package com.example.pa.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pa.controller.DTO.PedidosDTO.PedidosDTO;
import com.example.pa.controller.Mapper.PedidosMapper;
import com.example.pa.model.Pedidos;
import com.example.pa.service.EstadisticasService;
import com.example.pa.service.PedidosService;



@RestController
@RequestMapping("/api/estadisticas")
public class InformeVentaController {

    @Autowired
    private EstadisticasService estadisticasService;

    @Autowired
    private PedidosService pedidoService;

    @Autowired
    private PedidosMapper pedidoMapper;

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
        
        // Limitar la lista a 5 productos o menos
        List<Map<String, Object>> productosLimitados = productos.size() > 5 ? productos.subList(0, 5) : productos;
        
        return ResponseEntity.ok(productosLimitados);
    }

    @GetMapping("/productosmasrecaudados")
    public ResponseEntity<List<Map<String, Object>>> obtenerProductoCostosoMasVendidos() {
        List<Map<String, Object>> productos = estadisticasService.obtenerProductoCostosoMasVendidos();
        
        // Limitar la lista a 5 productos o menos
        List<Map<String, Object>> productosLimitados = productos.size() > 5 ? productos.subList(0, 5) : productos;
        
        return ResponseEntity.ok(productosLimitados);
    }

    @GetMapping("/pedidos_por_fechas")
    public ResponseEntity<Map<String, Object>> obtenerPedidosPorFecha(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {
    
        List<Pedidos> pedidos;
    
        if (fechaInicio != null && fechaFin != null) {
            pedidos = pedidoService.obtenerPedidosPorRangoDeFechas(fechaInicio, fechaFin);
        } else {
            pedidos = pedidoService.obtenerTodosLosPedidos();
        }
    
        List<PedidosDTO> pedidosDTO = pedidos.stream()
                .map(pedidoMapper::toDTO)
                .collect(Collectors.toList());
        
        Double ventasTotales = estadisticasService.calcularVentasTotales(fechaInicio, fechaFin);
        Long pedidosTotales = estadisticasService.contarPedidos(fechaInicio, fechaFin);
        
        Map<String, Object> response = Map.of(
                "pedidos", pedidosDTO,
                "ventasTotales", ventasTotales,
                "pedidosTotales", pedidosTotales
        );
        
        return ResponseEntity.ok(response);
    }    

}

