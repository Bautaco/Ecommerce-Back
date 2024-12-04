package com.example.pa.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
    @Min(value = 0)
    private double precio;

    private String sku; //Codigo Unico de referencia para el Producto

    private int stock;

    private boolean activo=true; //Indicador del Producto (Activo/Inactivo)

    @Min(value = 0, message = "El umbral de stock bajo debe ser mayor o igual a 0.")
    private int UmbralStockBajo;

    //Almacenamiento de URLs de las imágenes del producto
    @ElementCollection
    private List<String> imagenes;

    //Relaciones (Marca/Categoria/SubCategoria/Variante)
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;
    

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca Marca;
    
    @ManyToOne
    @JoinColumn(name = "subcategoria_id")
    private SubCategoria subcategoria;

    @ManyToOne
    @JoinColumn(name = "Variante_id")
    private Variante variante;



    //constructor

    public Producto(Long id, String nombre, String descripcion, @Min(0) double precio, String sku, int stock,
            boolean activo, int umbralStockBajo, List<String> imagenes, Categoria categoria,
            com.example.pa.model.Marca marca, SubCategoria subcategoria, Variante variante) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.sku = sku;
        this.stock = stock;
        this.activo = activo;
        this.UmbralStockBajo = umbralStockBajo;
        this.imagenes = imagenes;
        this.categoria = categoria;
        this.Marca = marca;
        this.subcategoria = subcategoria;
        this.variante = variante;
    }

    //Getter 
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getSku() {
        return sku;
    }

    public int getStock() {
        return stock;
    }

    public boolean isActivo() {
        return activo;
    }

    public List<String> getImagenes() {
        return imagenes;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Variante getVariante() {
        return variante;
    }

    public int getUmbralStockBajo() {
        return UmbralStockBajo;
    }


//Setters
     
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setVariantes(Variante variante) {
        this.variante = variante;
    }
  
    public void setUmbralStockBajo(int umbralStockBajo) {
        this.UmbralStockBajo = umbralStockBajo;
    }

    public Marca getMarca() {
        return Marca;
    }

    public void setMarca(Marca marca) {
        Marca = marca;
    }

    public SubCategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(SubCategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public void add(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    
}