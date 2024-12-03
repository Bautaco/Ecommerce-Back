package com.example.pa.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa.model.Pedidos;
import com.example.pa.model.Producto;
import com.example.pa.repository.PedidosRepository;


@Service


 
public class PedidosService {
    @Autowired
    private PedidosRepository compraRepository;
    
    public  List<Pedidos> findAll() {
        return compraRepository.findAll();
    }
    

    // Buscar una compra por ID
    public Pedidos findById(Long id) {
        return compraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada con ID: " + id));
    }

    //  actualizar una compra
    public Pedidos saveOrUpdate(Pedidos compra) {
        return compraRepository.save(compra);
    }


    // Agregar un producto a una compra
    public Pedidos agregarProducto(Long compraId,Producto producto ) {
        Pedidos compra = findById(compraId); // Buscar la compra
        compra.agregarProducto(producto); // Agregar el producto
        return compraRepository.save(compra); // Guardar la compra actualizada
    }

    // Eliminar un producto de una compra
    public Pedidos eliminarProducto(Long compraId, Long productoId) {
        Pedidos compra = findById(compraId); // Buscar la compra
        compra.eliminarProducto(productoId); // Eliminar el producto por ID
        return compraRepository.save(compra); // Guardar la compra actualizada
    }
    // crear compra
    public Pedidos crearPedidos(long id,List<Producto>listaProducto)
    {
        Pedidos compra = new Pedidos (id,listaProducto);
        return compraRepository.save(compra);
    }
    //Eliminar Pedido
    public void eliminarPedidos(long id){
        Optional<Pedidos> compraOpt = compraRepository.findById(id);
        if (compraOpt.isPresent()){
            Pedidos compra= compraOpt.get();
            compra.setActivo(false); //eliminacion loguica
        }
        
    }
}