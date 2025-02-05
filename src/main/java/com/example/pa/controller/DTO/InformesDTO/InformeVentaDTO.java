package com.example.pa.controller.DTO.InformesDTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InformeVentaDTO {

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double ventasTotales;
    private int numeroPedidos;
    private String productosMasVendidos;
    
    
}

