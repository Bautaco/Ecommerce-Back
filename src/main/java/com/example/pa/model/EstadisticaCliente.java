package com.example.pa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EstadisticaCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clienteId;  // Relación con Cliente
    private int frecuenciaCompra;
    private double valorPromedioPedido;
    private String productosFavoritos;
    
    //Contructorw
    public EstadisticaCliente(Long id, Long clienteId, int frecuenciaCompra, double valorPromedioPedido,
            String productosFavoritos) {
        this.id = id;
        this.clienteId = clienteId;
        this.frecuenciaCompra = frecuenciaCompra;
        this.valorPromedioPedido = valorPromedioPedido;
        this.productosFavoritos = productosFavoritos;
    }

    public EstadisticaCliente() {

    }

    
}

