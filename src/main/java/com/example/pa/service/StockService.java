package com.example.pa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.pa.model.Producto;
import com.example.pa.repository.ProductoRepository;
@Service
public class StockService {
     
    
    @Autowired
    private ProductoRepository productoRepository;

    // Método que devuelve productos con stock bajo
    public List<Producto> obtenerProductosConStockBajo() {
        return productoRepository.findAll()
            .stream()
            .filter(producto -> producto.getStock() < producto.getUmbralStockBajo())
            .collect(Collectors.toList());
        }
    

     // Método que verifica los niveles de stock y envía alertas
     public void verificarStock() {
        List<Producto> productosConStockBajo = obtenerProductosConStockBajo();
        for (Producto producto : productosConStockBajo) {
            enviarAlerta(producto);
        }
    }

    private void enviarAlerta(Producto producto) {
        // Implementar la lógica para enviar la alerta
        System.out.println("Alerta: El stock de " + producto.getNombre() + " está bajo. Stock actual: " + producto.getStock());
    }

    public void registrarAjusteStock(Long productoId, Integer cantidadAjustada, String razonAjuste) {
        // Verificar si el producto existe
        Producto producto = productoRepository.findById(productoId)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    
        // Realizar el ajuste de stock (sumar o restar la cantidad ajustada)
        int nuevoStock = producto.getStock() + cantidadAjustada;
        
        // Validar que el stock no sea negativo
        if (nuevoStock < 0) {
            throw new IllegalArgumentException("El ajuste de stock no puede dejar el inventario en números negativos.");
        }
    
        // Actualizar el stock del producto
        producto.setStock(nuevoStock);
    
        // Persistir el producto con el nuevo stock
        productoRepository.save(producto);
    
        // Aquí puedes registrar la razón del ajuste si deseas, por ejemplo, en una entidad separada de "HistorialAjustesStock"
        // Esto puede ayudar a llevar un control detallado de por qué se realizaron los ajustes.
    
        System.out.println("Ajuste de stock realizado en producto: " + producto.getNombre() + ". Razón: " + razonAjuste);
    }
    
}
