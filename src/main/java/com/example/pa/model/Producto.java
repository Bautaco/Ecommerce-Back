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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    private boolean activo=true; //Indicador del Producto (Activo/Inactivo)

    private int stock;

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
    @JoinColumn(name = "pedidos_id")
    private Pedidos pedidos;
    

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca Marca;
    
    @ManyToOne
    @JoinColumn(name = "subcategoria_id")
    private SubCategoria subcategoria;

    @ManyToOne
    @JoinColumn(name = "Variante_id")
    private Variante variante;

    public void add(Producto producto) {
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

}
