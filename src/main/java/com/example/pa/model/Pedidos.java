package com.example.pa.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Entity
@Setter
@Getter
@AllArgsConstructor
public class Pedidos {

   
    public enum Estado{En_proceso,Enviado,Completado}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long clienteId; // ID del cliente

    private boolean activo;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private LocalDateTime fechaCreacion;

    private double total; // Total del pedido

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProductoPedido> productos = new ArrayList<>();

    public Pedidos() {
        this.fechaCreacion = LocalDateTime.now();
        this.estado = Estado.En_proceso;
    }

    public void agregarProducto(ProductoPedido productoPedido) {
        this.productos.add(productoPedido);
        productoPedido.setPedido(this);
        this.total += productoPedido.getSubtotal();
    }

    public void eliminarProducto(ProductoPedido productoPedido) {
        this.productos.remove(productoPedido);
        productoPedido.setPedido(null);
        this.total -= productoPedido.getSubtotal();
    }
}