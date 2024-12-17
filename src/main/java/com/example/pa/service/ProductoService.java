package com.example.pa.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa.Excepciones.ProductoNotFoundException;
import com.example.pa.model.Producto;
import com.example.pa.repository.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    // Repositorio para manejar productos
    private ProductoRepository productoRepository;

    private static final Logger log = LoggerFactory.getLogger(ProductoService.class);

    @Autowired
    private StockService stockService;

    // Listado de Productos
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }
   
    //Listado de Productos Activos(True)
    public List<Producto> listarProductosActivos() {
        return productoRepository.findByActivoTrue(); 
    }
    
    //Creacion de un Nuevo Producto
    public Producto crearProducto(Producto producto) {
        stockService.verificarStock(); // Verificar después de crear
        return productoRepository.save(producto);
    }

    //Actualizacion de Productos Existentes 
    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        Optional<Producto> optionalProducto = productoRepository.findById(id); // Buscar el Producto por ID
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            // Actualiza los campos del producto con los nuevos valores
            producto.setNombre(productoActualizado.getNombre());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setCategoria(productoActualizado.getCategoria());
            producto.setImagenes(productoActualizado.getImagenes());
            producto.setStock(productoActualizado.getStock());
            producto.setActivo(productoActualizado.isActivo());// Actualiza Estado (Activo)
            stockService.verificarStock(); // Verificar después de actualizar
            return productoRepository.save(producto);// Guarda el producto actualizado
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }

    //Eliminacion de Producto (Cambio de estado a "Inactivo")
    public void eliminarProducto(Long id) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            producto.setActivo(false);  // Cambia Estado (inactivo)
            productoRepository.save(producto);// Guarda el producto actualizado
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }
    
    // Recuperación de Producto (Cambio de estado a "Activo")
    public Producto recuperarProducto(Long id) {
        // Busca el producto por ID
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new ProductoNotFoundException("Producto con ID " + id + " no encontrado"));

        // Cambia el estado a "Activo" solo si no está activo
        if (!producto.isActivo()) {
            producto.setActivo(true);  // Cambiar estado a activo
            productoRepository.save(producto); // Guardar el producto actualizado
            log.info("Producto con ID {} ha sido reactivado", id); // Log de recuperación exitosa
        } else {
            log.warn("El producto con ID {} ya estaba activo", id); // Log de advertencia
        }

        return producto;
    }


    //Listado de Productos Activos(True) e Inactivos(false)
    public List<Producto> listarTodosLosProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    //Validacion de Precios Positivo
    @SuppressWarnings("unused")
    private void ValidarPrecio(double precio) {
        if (precio < 0) {
            throw new  IllegalArgumentException("El precio no puede ser negativo");
        }
    }

    //Verificacion de Stock Bajo
    public void VerificarStockBajo(Producto producto){
        //Si el stck esta por debajo del Umbral
        if (producto.getStock() < producto.getUmbralStockBajo()){
            //Generador de Alerta
            generarAlertaStockBajo(producto);// Llama al método para generar alerta
        }
    }



    // Método privado para generar una alerta de stock bajo
    private void generarAlertaStockBajo(Producto producto) {
        // Aquí va la lógica para enviar la alerta
        System.out.println("¡Alerta! El producto " + producto.getNombre() + " tiene el stock bajo.");
    }

    // Método para encontrar un producto por su ID
    public Producto findById(Long id) {
        Optional<Producto> productoOpt = productoRepository.findById(id);
        return productoOpt.orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con id: " + id));
    }

     // Método para guardar un producto
    public void save(Producto producto) {
        // Aquí se puede agregar validaciones si es necesario
        productoRepository.save(producto);
    }

     
}
