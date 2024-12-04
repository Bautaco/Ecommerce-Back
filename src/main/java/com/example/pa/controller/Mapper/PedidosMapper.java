package com.example.pa.controller.Mapper;

import org.mapstruct.Mapper;

import com.example.pa.controller.DTO.PedidosDTO.PedidosDTO;
import com.example.pa.model.Pedidos;

@Mapper
public interface PedidosMapper {

    PedidosDTO toDO (Pedidos pedidos);
    Pedidos toEmtity (PedidosDTO pedidosDTO);
}
