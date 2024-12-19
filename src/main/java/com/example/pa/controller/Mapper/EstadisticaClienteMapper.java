package com.example.pa.controller.Mapper;

import com.example.pa.controller.DTO.EstadisticaDTO.EstadisticaClienteDTO;
import com.example.pa.model.EstadisticaCliente;

public class EstadisticaClienteMapper {

    public static EstadisticaClienteDTO toDTO(EstadisticaCliente EstadisticaCliente) {
        EstadisticaClienteDTO dto = new EstadisticaClienteDTO();
        dto.setFrecuenciaCompra(EstadisticaCliente.getFrecuenciaCompra());
        dto.setValorPromedioPedido(EstadisticaCliente.getValorPromedioPedido());
        dto.setProductosFavoritos(EstadisticaCliente.getProductosFavoritos());
        return dto;
    }

    public static EstadisticaCliente toEntity(EstadisticaClienteDTO dto) {
        EstadisticaCliente entity = new EstadisticaCliente();
        entity.setFrecuenciaCompra(dto.getFrecuenciaCompra());
        entity.setValorPromedioPedido(dto.getValorPromedioPedido());
        entity.setProductosFavoritos(dto.getProductosFavoritos());
        return entity;
    }
}

