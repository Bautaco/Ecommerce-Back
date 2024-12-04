package com.example.pa.controller.DTO.EstadisticaDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadisticaClienteDTO {
    
    private Long clienteId;
    private int frecuenciaCompra;
    private double valorPromedioPedido;
    private String productosFavoritos;
    
    //Constructor
    public EstadisticaClienteDTO(Long clienteId, int frecuenciaCompra, double valorPromedioPedido,
            String productosFavoritos) {
        this.clienteId = clienteId;
        this.frecuenciaCompra = frecuenciaCompra;
        this.valorPromedioPedido = valorPromedioPedido;
        this.productosFavoritos = productosFavoritos;
    }

    public EstadisticaClienteDTO() {
        
    }

    

}
