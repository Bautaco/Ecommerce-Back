package com.example.pa.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Consulta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private LocalDateTime fechaEnvio;

    @Enumerated(EnumType.STRING)
    private EstadoConsulta estado = EstadoConsulta.PENDIENTE;// Pendiente, En Proceso, Resuelta

    @ElementCollection
    private List<String> archivosAdjuntos;

    //Constructor
    public Consulta(Long id, String descripcion, LocalDateTime fechaEnvio, EstadoConsulta estado,
            List<String> archivosAdjuntos) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
        this.archivosAdjuntos = archivosAdjuntos;
    }
    
    // Getters y setters de cada atributo
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
        }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }
    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
    public EstadoConsulta getEstado() {
        return estado;
    }
    public void setEstado(EstadoConsulta estado) {
        this.estado = estado;
    }
    public void setArchivosAdjuntos(List<String> rutasArchivos) {
        this.archivosAdjuntos = rutasArchivos;
    } 

}
