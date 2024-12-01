package com.example.pa.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa.model.Compra;
import com.example.pa.model.Marca;
import com.example.pa.model.Producto;
import com.example.pa.repository.CompraRepository;


@Service


 
public class CompraService {
    @Autowired
    private CompraRepository compraRepository;
    
    public  List<Compra> findAll() {
        return compraRepository.findAll();
    }
    

    // Buscar una compra por ID
    public Compra findById(Long id) {
        return compraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada con ID: " + id));
    }

    //  actualizar una compra
    public Compra saveOrUpdate(Compra compra) {
        return compraRepository.save(compra);
    }


    // Agregar un producto a una compra
    public Compra agregarProducto(Long compraId,Producto producto ) {
        Compra compra = findById(compraId); // Buscar la compra
        compra.agregarProducto(producto); // Agregar el producto
        return compraRepository.save(compra); // Guardar la compra actualizada
    }

    // Eliminar un producto de una compra
    public Compra eliminarProducto(Long compraId, Long productoId) {
        Compra compra = findById(compraId); // Buscar la compra
        compra.eliminarProducto(productoId); // Eliminar el producto por ID
        return compraRepository.save(compra); // Guardar la compra actualizada
    }
    // crear compra
    public Compra crearCompra(long id,List<Producto>listaProducto)
    {
        Compra compra = new Compra (id,listaProducto);
        return compraRepository.save(compra);
    }


    // public void eliminarMarca(Long id) {
    //     Optional<Marca> marcaOpt = marcaRepository.findById(id);
    //     if (marcaOpt.isPresent()) {
    //         Marca marca = marcaOpt.get();
    //         marca.setActivo(false);  // Eliminación lógica
    //         marcaRepository.save(marca);
    //     }
    // }
    public void eliminarCompra(long id){
        Optional<Compra> compraOpt = compraRepository.findById(id);
        if (compraOpt.isPresent()){
            Compra compra= compraOpt.get();
            compra.set
        }

    }
}