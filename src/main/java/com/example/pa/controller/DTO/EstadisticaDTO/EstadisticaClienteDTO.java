package com.example.pa.controller.DTO.EstadisticaDTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadisticaClienteDTO {
    
     private Long id;
    private LocalDate fechaCompra;
    private Integer frecuenciaCompra;
    private String productosFavoritos;
    private Double valorPromedioPedido;   

}
