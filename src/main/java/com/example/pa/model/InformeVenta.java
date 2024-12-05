package com.example.pa.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InformeVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double ventasTotales;
    private int numeroPedidos;
    private String productosMasVendidos;
   
   //Contructor
    public InformeVenta(Long id, LocalDate fechaInicio, LocalDate fechaFin, double ventasTotales, int numeroPedidos,
            String productosMasVendidos) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ventasTotales = ventasTotales;
        this.numeroPedidos = numeroPedidos;
        this.productosMasVendidos = productosMasVendidos;
    }

    public InformeVenta() {
    }

    //Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getVentasTotales() {
        return ventasTotales;
    }

    public void setVentasTotales(double ventasTotales) {
        this.ventasTotales = ventasTotales;
    }

    public int getNumeroPedidos() {
        return numeroPedidos;
    }

    public void setNumeroPedidos(int numeroPedidos) {
        this.numeroPedidos = numeroPedidos;
    }

    public String getProductosMasVendidos() {
        return productosMasVendidos;
    }

    public void setProductosMasVendidos(String productosMasVendidos) {
        this.productosMasVendidos = productosMasVendidos;
    }

}

