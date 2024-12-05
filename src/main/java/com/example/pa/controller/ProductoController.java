package com.example.pa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pa.model.Producto;
import com.example.pa.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Listar todos los productos activos
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductosActivos();
    }

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        if (producto.getPrecio() < 0) {
            return ResponseEntity.badRequest().body(null); // Respuesta de error
        }
        Producto nuevoProducto = productoService.crearProducto(producto);
        return ResponseEntity.ok(nuevoProducto);
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        // Verificar si producto Actualizado es null
        if (productoActualizado == null) {
            return ResponseEntity.badRequest().body(null); // Manejar el caso en el que no se pase un objeto en la solicitud
        }
    
        // Verificar si el precio es negativo
        if (productoActualizado.getPrecio() < 0) {
            return ResponseEntity.badRequest().body(null); // Manejar error de precio negativo
        }
    
        // Actualizar el producto si todo es válido
        Producto producto = productoService.actualizarProducto(id, productoActualizado);
        return ResponseEntity.ok(producto);
    }

    // Eliminar un producto (cambio de estado a inactivo)
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }

    // Recuperar un producto eliminado
    @PutMapping("/recuperar/{id}")
    public Producto recuperarProducto(@PathVariable Long id) {
        return productoService.recuperarProducto(id);
    }

   
}