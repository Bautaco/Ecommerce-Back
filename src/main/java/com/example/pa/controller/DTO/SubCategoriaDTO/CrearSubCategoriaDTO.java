package com.example.pa.controller.DTO.SubCategoriaDTO;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

public class CrearSubCategoriaDTO {

    @NotNull(message = "El nombre no puede estar vacío.")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres.")
    private String nombre;

    private Boolean activo;

    @NotNull(message = "La categoría no puede estar vacía.")
    private Long categoriaId;

    // Método para verificar si todos los campos están vacíos
    public boolean isEmpty() {
        return nombre == null && activo == null && categoriaId == null;
    }
}

