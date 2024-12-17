package com.example.pa.controller.Mapper;

import org.mapstruct.Mapper;

import com.example.pa.controller.DTO.PedidosDTO.PedidosDTO;
import com.example.pa.model.Pedidos;

@Mapper(componentModel = "spring")
public interface PedidosMapper {

    PedidosDTO toDTO(Pedidos pedidos);

    Pedidos toEntity(PedidosDTO pedidosDTO);
<<<<<<< HEAD
}
=======
}
>>>>>>> main
