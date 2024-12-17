package com.example.pa.controller.DTO.ProductoDTO;

import java.util.List;

import com.example.pa.controller.DTO.VarianteDTO.VarianteDTO;
import com.example.pa.model.Categoria;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    
    @Min(value = 0)
    private double precio;
    
    private String sku; //Codigo Unico de referencia para el Producto
    private int stock;
    private boolean activo=true; //Indicador del Producto (Activo/Inactivo)
    private int umbralStockBajo;
    private List<String> imagenes; //Almacenamiento de URLs de las imágenes del producto
    private long categoriaId; // Solo el ID para evitar circularidad de datos
    private long marcaId;
    private long subcategoriaId;
    private List<VarianteDTO> variantes; // Las variantes también deberían tener su propio DTO

    //constructor

    public ProductoDTO(Long id, String nombre, String descripcion, double precio, String sku, int stock,
                       boolean activo, int umbralStockBajo, List<String> imagenes, Long categoriaId,
                       Long marcaId, Long subcategoriaId, List<VarianteDTO> variantes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.sku = sku;
        this.stock = stock;
        this.activo = activo;
        this.umbralStockBajo = umbralStockBajo;
        this.imagenes = imagenes;
        this.categoriaId = categoriaId;
        this.marcaId = marcaId;
        this.subcategoriaId = subcategoriaId;
        this.variantes = variantes;
    }

     // Getters y Setters
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public int getUmbralStockBajo() {
        return umbralStockBajo;
    }

    public void setUmbralStockBajo(int umbralStockBajo) {
        this.umbralStockBajo = umbralStockBajo;
    }

    public List<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Long marcaId) {
        this.marcaId = marcaId;
    }

    public Long getSubcategoriaId() {
        return subcategoriaId;
    }

    public void setSubcategoriaId(Long subcategoriaId) {
        this.subcategoriaId = subcategoriaId;
    }

    public List<VarianteDTO> getVariantes() {
        return variantes;
    }

    public void setVariantes(List<VarianteDTO> variantes) {
        this.variantes = variantes;
    }

    public Categoria getCategoria() {
        throw new UnsupportedOperationException("Unimplemented method 'getCategoria'");
    }
}
