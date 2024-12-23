package com.example.pa.controller.DTO.CategoriaDTO;

public class CategoriaDTO {
    
    private Long id;
    private String nombre;
    private boolean activo = true; //Indicador de Categoria (Activa/Inactiva)

    //Contructor
    public CategoriaDTO(Long id, String nombre, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }


    //Getter y Setter
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


    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
}
