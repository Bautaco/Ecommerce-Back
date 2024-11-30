package com.example.pa.controller.DTO.SubCategoriaDTO;

public class SubCategoriaDTO {

    private Long id;
    private String nombre;
    private boolean activo;
    private Long categoriaId;
    private String categoriaNombre;

    // Constructor
    public SubCategoriaDTO(Long id, String nombre, boolean activo, Long categoriaId, String categoriaNombre) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
        this.categoriaId = categoriaId;
        this.categoriaNombre = categoriaNombre;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }
}

