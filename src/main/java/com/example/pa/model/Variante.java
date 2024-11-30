package com.example.pa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Variante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Color; //Rojo , Negro, Gris, etc
    
    private String Talle; // S, M, L, XL, XXL, ETC

    private String Material; // Algodon, Friza, etc

    private String Estilo; // Urbano, Deportivo, Etc

    private int stock;

    private boolean activo = true; // Indica si la variante está activa o eliminada

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    //getter and Setter
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