package com.example.pa.controller.Mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.pa.controller.DTO.PedidosDTO.PedidosDTO;
import com.example.pa.model.Pedidos;

@Component
public class PedidosMapper {

    private final ProductoPedidoMapper productoPedidoMapper;

    public PedidosMapper(ProductoPedidoMapper productoPedidoMapper) {
        this.productoPedidoMapper = productoPedidoMapper;
    }

    public PedidosDTO toDTO(Pedidos pedido) {
        PedidosDTO dto = new PedidosDTO();
        dto.setId(pedido.getId());
        dto.setClienteId(pedido.getClienteId());
        dto.setEstado(pedido.getEstado().name());
        dto.setFechaCreacion(pedido.getFechaCreacion());
        dto.setTotal(pedido.getTotal());
        dto.setProductos(pedido.getProductos().stream()
                .map(productoPedidoMapper::toDTO)
                .collect(Collectors.toList()));
        return dto;
    }
}