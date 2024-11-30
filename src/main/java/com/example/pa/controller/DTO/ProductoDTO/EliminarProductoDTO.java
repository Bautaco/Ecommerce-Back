package com.example.pa.controller.DTO.ProductoDTO;

import jakarta.validation.constraints.NotNull;

public class EliminarProductoDTO {
    
    private Long id;

    private boolean activo = true; // Elimina el producto de activo

    //Constructor
    public EliminarProductoDTO(@NotNull(message = "El ID no puede ser nulo") Long id, boolean activo) {
        this.id = id;
        this.activo = activo;
    }

    //Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
}
