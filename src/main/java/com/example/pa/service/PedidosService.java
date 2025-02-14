package com.example.pa.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa.model.Pedidos;
import com.example.pa.model.Producto;
import com.example.pa.model.ProductoPedido;
import com.example.pa.repository.PedidosRepository;
import com.example.pa.repository.ProductoPedidoRepository;
import com.example.pa.repository.ProductoRepository;


@Service
public class PedidosService {
     @Autowired
    private PedidosRepository pedidoRepository;

    @Autowired
    private ProductoPedidoRepository productoPedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public Pedidos crearPedido(Long clienteId) {
        Pedidos pedido = new Pedidos();
        pedido.setClienteId(clienteId);
        return pedidoRepository.save(pedido);
    }

    public Pedidos agregarProducto(Long pedidoId, Long productoId, int cantidad) {
        Pedidos pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        ProductoPedido productoPedido = new ProductoPedido();
        productoPedido.setProducto(producto);
        productoPedido.setCantidad(cantidad);
        productoPedido.calcularSubtotal();

        pedido.agregarProducto(productoPedido);
        productoPedidoRepository.save(productoPedido);

        return pedidoRepository.save(pedido);
    }

    public Pedidos eliminarProducto(Long pedidoId, Long productoPedidoId) {
        Pedidos pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        ProductoPedido productoPedido = productoPedidoRepository.findById(productoPedidoId)
                .orElseThrow(() -> new RuntimeException("ProductoPedido no encontrado"));

        pedido.eliminarProducto(productoPedido);
        productoPedidoRepository.delete(productoPedido);

        return pedidoRepository.save(pedido);
    }

    public List<Pedidos> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedidos> obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedidos actualizarEstado(Long pedidoId, Pedidos.Estado estado) {
        Pedidos pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        pedido.setEstado(estado);
        return pedidoRepository.save(pedido);
    }
    
    public List<Producto> obtenerProductosPorId(List<Long> productoIds) {
        return productoRepository.findAllById(productoIds);
    }

    public Pedidos guardarPedido(Pedidos pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedidos> obtenerPedidosPorRangoDeFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
    return pedidoRepository.pedidosporfecha(fechaInicio, fechaFin);
}

    
}