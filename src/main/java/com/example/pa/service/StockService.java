package com.example.pa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.pa.model.Producto;
import com.example.pa.model.Stock;
import com.example.pa.repository.ProductoRepository;
@Service
public class StockService {
     
    
    @Autowired
    private ProductoRepository productoRepository;

    // Método que devuelve productos con stock bajo
    public List<Producto> obtenerProductosConStockBajo() {
        return productoRepository.findAll()
            .stream()
            .filter(producto -> {
                Stock stock = producto.getStock();
                return stock != null && stock.getCantidad() < stock.getUmbralStockBajo();
            })
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

    public void registrarAjusteStock(Long productoId, int cantidadAjuste) {
        // Lógica para ajustar el stock de un producto
        Stock stock = stockRepository.findByProductoId(productoId);
        if (stock != null) {
            stock.setCantidad(stock.getCantidad() + cantidadAjuste); // Ajuste del stock
            stockRepository.save(stock); // Guardar el cambio en la base de datos
        } else {
            throw new EntityNotFoundException("Producto no encontrado");
        }
    }

}
