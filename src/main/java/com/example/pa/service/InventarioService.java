package com.example.pa.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa.model.AjusteInventario;
import com.example.pa.model.Producto;
import com.example.pa.repository.AjusteInventarioRepository;
import com.example.pa.repository.ProductoRepository;

@Service
public class InventarioService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private AjusteInventarioRepository ajusteInventarioRepository;

    public void registrarAjusteStock(Long productoId, int cantidad, String razon) {
        Producto producto = productoRepository.findById(productoId)
                            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        
        producto.setStock(producto.getStock() + cantidad); // cantidad puede ser negativa para salidas
        productoRepository.save(producto);

        AjusteInventario ajuste = new AjusteInventario(productoId, producto, cantidad, razon, null);
        ajuste.setProducto(producto);
        ajuste.setCantidad(cantidad);
        ajuste.setRazon(razon);
        ajuste.setFecha(LocalDateTime.now());
        ajusteInventarioRepository.save(ajuste);
    }
}
