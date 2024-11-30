package com.example.pa.controller.DTO.VarianteDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CrearVarianteDTO {
    
    private String Material;

    private String Estilo;
   
    private String Color;
   
    private String Talle;

    @Min(value = 0, message = "El stock debe ser mayor o igual a 0.")
    private int stock;
    
    private Boolean activo = true;

    @NotNull(message = "El producto no puede estar vacío.")
    private Long productoId;

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public String getEstilo() {
        return Estilo;
    }

    public void setEstilo(String estilo) {
        Estilo = estilo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getTalle() {
        return Talle;
    }

    public void setTalle(String talle) {
        Talle = talle;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }


    
}
