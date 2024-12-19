package com.example.pa.controller.DTO.PedidosDTO;

import java.util.List;

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
    private long  cliente;  // Objeto completo del cliente
    private List<Producto> producto;  // Lista de productos

    // Constructor para facilitar la creación
    public PedidosDTO(long id, List<Producto> producto, Estado estado, boolean activo, long cliente) {
        this.id = id;
        this.producto = producto;
        this.estado = estado;
        this.activo = activo;
        this.cliente = cliente;
    }

    public double getTotal() {
        return producto.stream().mapToDouble(p -> p.getPrecio() * p.getStock()).sum();
    }
}

//-------------------------------------------------------------------------
// package com.example.pa.controller.DTO.PedidosDTO;
// import lombok.Data;
// import java.util.List;

// import com.example.pa.controller.DTO.ProductoDTO.ProductoDTO;

// @Data
// public class PedidosDTO {
//     private long id;                    // ID del pedido
//     private boolean activo;             // Si el pedido está activo o no
//     private Estado estado;              // Estado del pedido
//     private long cliente;               // ID del cliente asociado al pedido
//     private List<ProductoDTO> productos; // Lista de productos como DTOs

//     // Constructor para inicializar los campos
//     public PedidosDTO(long id, boolean activo, Estado estado, long cliente, List<ProductoDTO> productos) {
//         this.id = id;
//         this.activo = activo;
//         this.estado = estado;
//         this.cliente = cliente;
//         this.productos = productos;
//     }

//     // Constructor vacío para frameworks (como MapStruct o Jackson)
//     public PedidosDTO() {
//     }

//     // Método para calcular el total del pedido
//     public double getTotal() {
//         return productos.stream().mapToDouble(p -> p.getPrecio() * p.getCantidad()).sum();
//     }

//     // Enum Estado (puedes moverlo a una clase aparte si lo prefieres)
//     public enum Estado {
//         En_proceso, Enviado, Completado
//     }
// }

    
    
