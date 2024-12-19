package com.example.pa.model;

import java.time.LocalDate;

import com.example.pa.User.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadisticaCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaCompra;
    private Integer frecuenciaCompra; // Número de compras realizadas
    private String productosFavoritos; // Productos favoritos del cliente
    private Double valorPromedioPedido; // Promedio de gasto por pedido

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Relación con el usuario
}

