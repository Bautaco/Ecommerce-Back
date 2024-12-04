package com.example.pa.controller.DTO.InformesDTO;

import java.time.LocalDate;

public class InformeVentaDTO {

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double ventasTotales;
    private int numeroPedidos;
    private String productosMasVendidos;
    
    // Constructor
    public InformeVentaDTO(LocalDate fechaInicio, LocalDate fechaFin, double ventasTotales, int numeroPedidos,
            String productosMasVendidos) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ventasTotales = ventasTotales;
        this.numeroPedidos = numeroPedidos;
        this.productosMasVendidos = productosMasVendidos;
    }

    public InformeVentaDTO() {
    
    }

    //Getter & Setter
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

