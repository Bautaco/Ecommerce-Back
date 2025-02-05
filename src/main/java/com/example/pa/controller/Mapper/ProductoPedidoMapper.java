package com.example.pa.controller.Mapper;

import org.springframework.stereotype.Component;

import com.example.pa.controller.DTO.ProductoPedidoDTO.ProductoPedidoDTO;
import com.example.pa.model.ProductoPedido;

@Component
public class ProductoPedidoMapper {
    
    public ProductoPedidoDTO toDTO(ProductoPedido productoPedido) {
        ProductoPedidoDTO dto = new ProductoPedidoDTO();
        dto.setId(productoPedido.getId());
        dto.setProductoId(productoPedido.getProducto().getId());
        dto.setNombreProducto(productoPedido.getProducto().getNombre());
        dto.setCantidad(productoPedido.getCantidad());
        dto.setPrecioUnitario(productoPedido.getProducto().getPrecio());
        dto.setSubtotal(productoPedido.getSubtotal());
        return dto;
    }
}
