package com.example.pa.controller.DTO.VarianteDTO;

import com.example.pa.model.Producto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class VarianteDTO {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Color;
    
    private String Talle;

    private String Material;
    
    private String Estilo;

    private int stock;

    private boolean activo = true; // Indica si la variante está activa o eliminada

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    //Constructor
    public VarianteDTO(Long id, String color, String talle, String material, String estilo, int stock, boolean activo,
            Producto producto) {
        this.id = id;
        Color = color;
        Talle = talle;
        Material = material;
        Estilo = estilo;
        this.stock = stock;
        this.activo = activo;
        this.producto = producto;
    }

    //Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
}
