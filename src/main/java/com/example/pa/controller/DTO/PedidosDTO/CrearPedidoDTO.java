package com.example.pa.controller.DTO.PedidosDTO;

import java.util.List;

import lombok.Data;


@Data
public class CrearPedidoDTO {
   
    private Long clienteId;
    private List<AgregarProductosDTO> productos;
}
