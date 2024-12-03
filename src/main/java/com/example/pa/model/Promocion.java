package com.example.pa.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private double porcentajeDescuento; // Descuento en porcentaje (0 - 100)

    @Column(columnDefinition = "DATE")
    private LocalDate fechaInicio;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaFin;

    private boolean activa;

    // Constructor, getters y setters
    public Promocion() {}

    public Promocion(String nombre, double porcentajeDescuento, LocalDate fechaInicio, LocalDate fechaFin, boolean activa) {
        this.nombre = nombre;
        this.porcentajeDescuento = porcentajeDescuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.activa = activa;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPorcentajeDescuento() { return porcentajeDescuento; }
    public void setPorcentajeDescuento(double porcentajeDescuento) { this.porcentajeDescuento = porcentajeDescuento; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
}
