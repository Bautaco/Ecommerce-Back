package com.example.pa.controller.DTO.ProductoPedidoDTO;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ProductoPedidoDTO {
    private Long id;
    private Long productoId;
    private String nombreProducto; // Nombre del producto
    private int cantidad;
    private double precioUnitario;
    private double subtotal; // precioUnitario * cantidad
    
    public ProductoPedidoDTO(Long id, Long productoId, String nombreProducto, int cantidad, double precioUnitario,
            double subtotal) {
        this.id = id;
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    
}
