package com.example.pa.controller.DTO.ProductoDTO;

import java.util.List;

import com.example.pa.controller.DTO.VarianteDTO.ActualizarVarianteDTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class ActualizarProductoDTO {

    @Size(min = 2, max = 100, message = "El Nombre debe tener entre 2 y 100 caracteres.")
    private String nombre;

    @Size(min = 1, message = "La Descripción no puede estar vacía.")
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Min(value = 0, message = "El precio debe ser mayor o igual a 0.")
    private Double precio;

    private String sku;

    @Min(value = 0, message = "El stock debe ser mayor o igual a 0.")
    private Integer stock;

    private Boolean activo;

    @Min(value = 0, message = "El umbral de stock bajo debe ser mayor o igual a 0.")
    private Integer umbralStockBajo;

    private List<String> imagenes;
    private Long categoriaId;
    private Long marcaId;
    private Long subcategoriaId;
    private List<ActualizarVarianteDTO> variantes;

    // Método para verificar si todos los campos están vacíos
    public boolean isEmpty() {
        return nombre == null && descripcion == null && precio == null && sku == null && stock == null
               && activo == null && umbralStockBajo == null && imagenes == null && categoriaId == null
               && marcaId == null && subcategoriaId == null && variantes == null;
    }

    
}
