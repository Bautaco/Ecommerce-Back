package com.example.pa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pa.controller.DTO.InventarioDTO.AjusteInventarioRequest;
import com.example.pa.controller.DTO.InventarioDTO.VarianteStockRequest;
import com.example.pa.model.Producto;
import com.example.pa.service.StockService;
import com.example.pa.service.VarianteService;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockService stockAlertaService;

    @Autowired
    private VarianteService varianteService;
    
    // Endpoint para obtener productos con stock bajo
    @GetMapping("/alertas")
    public List<Producto> obtenerProductosConStockBajo() {
        return stockAlertaService.obtenerProductosConStockBajo();
    }

    // Endpoint para registrar un ajuste de inventario
    @PostMapping("/ajuste")
    public ResponseEntity<String> registrarAjusteStock(@RequestBody AjusteInventarioRequest request) {
        stockAlertaService.registrarAjusteStock(request.getProductoId(), request.getCantidadAjustada(), request.getRazonAjuste());
        return ResponseEntity.ok("Ajuste de stock registrado correctamente");
    }

    // Endpoint para actualizar el stock de una variante
    @PostMapping("/variantes/{id}/ajuste")
    public ResponseEntity<String> ajustarStockVariante(@PathVariable Long id, @RequestBody VarianteStockRequest request) {
        varianteService.actualizarVariante(id, request.getCantidad());
        return ResponseEntity.ok("Stock de variante ajustado correctamente" );
    }

}
