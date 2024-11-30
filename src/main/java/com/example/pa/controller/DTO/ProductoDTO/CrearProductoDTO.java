package com.example.pa.controller.DTO.ProductoDTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CrearProductoDTO {
    @NotEmpty(message = "El Nombre no puede estar vacío.")
    @Size(min = 2, max = 100, message = "El Nombre debe tener entre 2 y 100 caracteres.")
    private String nombre;

    @NotEmpty(message = "La Descripción no puede estar vacía.")
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Min(value = 0, message = "El precio debe ser mayor o igual a 0.")
    private double precio;

    @Min(value = 0, message = "El stock debe ser mayor o igual a 0.")
    private int stock;

    @Min(value = 0, message = "El umbral de stock bajo debe ser mayor o igual a 0.")
    private int umbralStockBajo;

}
