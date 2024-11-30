package com.example.pa.controller.DTO.SubCategoriaDTO;

import jakarta.validation.constraints.NotNull;

public class EliminarSubCategoriaDTO {
    
    @NotNull(message = "El ID no puede estar vacío.")
    private Long id;
    
}
