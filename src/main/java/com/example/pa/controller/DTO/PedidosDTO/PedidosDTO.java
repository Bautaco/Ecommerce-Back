package com.example.pa.controller.DTO.PedidosDTO;

import java.util.List;

import com.example.pa.User.User;
import com.example.pa.model.Pedidos.Estado;
import com.example.pa.model.Producto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PedidosDTO {
    private long id;
    private boolean activo;
    private Estado estado;  // Usamos el enum directamente
    private User cliente;  // Objeto completo del cliente
    private List<Producto> productos;  // Lista de productos

    // Constructor para facilitar la creación
    public PedidosDTO(long id, List<Producto> productos, Estado estado, boolean activo, User cliente) {
        this.id = id;
        this.productos = productos;
        this.estado = estado;
        this.activo = activo;
        this.cliente = cliente;
    }

    // Constructor vacío para MapStruct
    public PedidosDTO() {}
    public double getTotal() {
        return productos.stream().mapToDouble(p -> p.getPrecio() * p.getStock()).sum();
    }
}
    
