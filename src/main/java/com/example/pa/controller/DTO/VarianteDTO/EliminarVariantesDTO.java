package com.example.pa.controller.DTO.VarianteDTO;

import jakarta.validation.constraints.NotNull;

public class EliminarVariantesDTO {
    
    @NotNull(message = "El ID no puede estar vacío.")
    private Long id;
}
