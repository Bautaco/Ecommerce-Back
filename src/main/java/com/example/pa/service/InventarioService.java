package com.example.pa.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa.model.AjusteInventario;
import com.example.pa.model.Producto;
import com.example.pa.model.Stock;
import com.example.pa.repository.AjusteInventarioRepository;
import com.example.pa.repository.ProductoRepository;
import com.example.pa.repository.StockRepository;

@Service
public class InventarioService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private AjusteInventarioRepository ajusteInventarioRepository;

    private StockRepository stockRepository;

    public void registrarAjusteStock(Long productoId, int cantidad, String razon) {
    // Busca el producto por ID, lanza excepción si no lo encuentra
    Producto producto = productoRepository.findById(productoId)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

    // Verifica si el producto tiene un objeto Stock asociado
    Stock stock = producto.getStock();
    if (stock == null) {
        throw new RuntimeException("El producto no tiene un stock asociado");
    }

    // Ajusta la cantidad de stock
    int nuevoStock = stock.getCantidad() + cantidad; // `cantidad` puede ser negativa (salida de stock)
    if (nuevoStock < 0) {
        throw new RuntimeException("El ajuste de stock no puede resultar en una cantidad negativa");
    }

    stock.setCantidad(nuevoStock);
    stockRepository.save(stock); // Guarda los cambios en el stock

    // Registra el ajuste de inventario
    AjusteInventario ajuste = new AjusteInventario();
    ajuste.setProducto(producto);
    ajuste.setCantidad(cantidad);
    ajuste.setRazon(razon);
    ajuste.setFecha(LocalDateTime.now());
    ajusteInventarioRepository.save(ajuste); // Guarda el ajuste en el repositorio
}

}
