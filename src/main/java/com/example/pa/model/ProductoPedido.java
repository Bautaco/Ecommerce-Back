package com.example.pa.model;

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
@NoArgsConstructor
@AllArgsConstructor

public class ProductoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedidos pedido;

    @Min(1)
    private int cantidad;

    private double subtotal;
    
    
    public ProductoPedido (Producto producto, Pedidos pedido, int cantidad) {
        this.producto = producto;
        this.pedido = pedido;
        this.cantidad = cantidad;
        this.subtotal = producto.getPrecio() * cantidad;
    }
   
    public void calcularSubtotal() {
        this.subtotal = producto.getPrecio() * cantidad;
    }
}
