package com.example.pa.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa.model.Pedidos;
import com.example.pa.model.Pedidos.Estado;
import com.example.pa.model.Producto;
import com.example.pa.repository.PedidosRepository;


@Service
public class PedidosService {
    @Autowired
    private PedidosRepository pedidosRepository;
    
    public  List<Pedidos> findAll() {
        return pedidosRepository.findByActivoTrue();
    }
    

    // Buscar una compra por ID
    public Pedidos findById(Long id) {
        return pedidosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada con ID: " + id));
    }

    //  actualizar una compra
    public Pedidos saveOrUpdate(Pedidos compra) {
        return pedidosRepository.save(compra);
    }


    // Agregar un producto a una compra
    public Pedidos agregarProducto(Long compraId,Producto producto ) {
        Pedidos compra = findById(compraId); // Buscar la compra
        compra.agregarProducto(producto); // Agregar el producto
        return pedidosRepository.save(compra); // Guardar la compra actualizada
    }

    // Eliminar un producto de una compra
    public Pedidos eliminarProducto(Long compraId, Long productoId) {
        Pedidos compra = findById(compraId); // Buscar la compra
        compra.eliminarProducto(productoId); // Eliminar el producto por ID
        return pedidosRepository.save(compra); // Guardar la compra actualizada
    }

    // crear compra
    public Pedidos crearPedidos(long id,List<Producto>listaProducto,long cliente)
    {
        Pedidos compra = new Pedidos (id,listaProducto,cliente);
        return pedidosRepository.save(compra);
    }


    //Eliminar Pedido
    public void eliminarPedidos(long id){
    Optional<Pedidos> compraOpt = pedidosRepository.findById(id);
    if (compraOpt.isPresent()){
        Pedidos compra = compraOpt.get();
        compra.setActivo(false); // Eliminación lógica: marca el pedido como inactivo
        pedidosRepository.save(compra); // Asegúrate de guardar los cambios en la base de datos
        }
    }


    public Pedidos actualizarEstadoPedido(Long id, String nuevoEstado) {
        // Buscar el pedido por ID
        Pedidos pedido = pedidosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));
    
        // Validar y convertir el nuevo estado
        Estado estadoValido = obtenerEstadoValido(nuevoEstado);
    
        // Actualizar el estado del pedido
        pedido.setEstado(estadoValido);
    
        // Guardar los cambios en la base de datos
        return pedidosRepository.save(pedido); // Retornar el pedido actualizado
    }
    
    // Método auxiliar para validar el estado
    private Estado obtenerEstadoValido(String nuevoEstado) {
        try {
            return Estado.valueOf(nuevoEstado.toUpperCase()); // Insensible a mayúsculas/minúsculas
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Estado no válido: " + nuevoEstado);
        }
    }

    public Pedidos recuperarPedido(Long id) {
        Optional<Pedidos> compraOpt = pedidosRepository.findById(id);
        if (compraOpt.isPresent()) {
            Pedidos compra = compraOpt.get();
            compra.setActivo(true); // Revertir la eliminación lógica
            return pedidosRepository.save(compra); // Guardar los cambios y devolver la entidad actualizada
        } else {
            throw new RuntimeException("Pedido no encontrado con ID: " + id);
        }
    }
    

}