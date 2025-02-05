package com.example.pa.controller.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import com.example.pa.controller.DTO.PedidosDTO.CrearPedidoDTO;
import com.example.pa.model.Pedidos;
import com.example.pa.model.Producto;
import com.example.pa.model.ProductoPedido;

@Mapper
public class CrearPedidoMapper {

    public Pedidos toEntity(CrearPedidoDTO crearPedidoDTO) {
        Pedidos pedido = new Pedidos();
        pedido.setClienteId(crearPedidoDTO.getClienteId());
        return pedido;
    }

    public List<ProductoPedido> toProductoPedidoList(CrearPedidoDTO crearPedidoDTO, List<Producto> productos) {
        return crearPedidoDTO.getProductos().stream().map(productoDTO -> {
            Producto producto = productos.stream()
                    .filter(p -> p.getId().equals(productoDTO.getProductoId()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            ProductoPedido productoPedido = new ProductoPedido();
            productoPedido.setProducto(producto);
            productoPedido.setCantidad(productoDTO.getCantidad());
            productoPedido.calcularSubtotal();
            return productoPedido;
        }).collect(Collectors.toList());
    }
}
