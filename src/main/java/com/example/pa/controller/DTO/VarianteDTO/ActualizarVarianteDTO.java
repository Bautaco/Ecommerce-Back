package com.example.pa.controller.DTO.VarianteDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class ActualizarVarianteDTO {
    
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres.")
    private String nombre;

    @SuppressWarnings("unused")
    private String color;

    @SuppressWarnings("unused")
    private String talla;

    @Min(value = 0, message = "El stock debe ser mayor o igual a 0.")
    private int stock;

    @SuppressWarnings("unused")
    private Boolean activo;

    @SuppressWarnings("unused")
    private Long productoId;

}
