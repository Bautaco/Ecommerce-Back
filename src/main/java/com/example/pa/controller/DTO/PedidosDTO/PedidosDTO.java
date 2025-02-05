package com.example.pa.controller.DTO.PedidosDTO;

import java.time.LocalDateTime;
import java.util.List;


import com.example.pa.controller.DTO.ProductoPedidoDTO.ProductoPedidoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidosDTO {
    private Long id;
    private Long clienteId;
    private String estado; // EN_PROCESO, ENVIADO, COMPLETADO
    private LocalDateTime fechaCreacion;
    private double total;
    private List<ProductoPedidoDTO> productos;


    public List<ProductoPedidoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoPedidoDTO> productos) { // <---- Asegurar que esto exista
        this.productos = productos;
    }
}
    
    
