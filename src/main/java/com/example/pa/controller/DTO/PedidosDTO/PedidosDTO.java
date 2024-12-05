package com.example.pa.controller.DTO.PedidosDTO;

import java.util.List;

import com.example.pa.model.Pedidos;
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
    private boolean activo = true;
    private Estado estado;
    //private Usuario cliente;
    private Pedidos pedidos;
    private List<Producto> productos;
    
        public PedidosDTO(long ID, List<Producto> listaProducto, Pedidos pedidos /*, Usuario cliente*/){
            //TODO traer usuario
            //this.cliente=cliente;
            this.id=ID;
        this.productos=listaProducto;
        this.estado = Estado.En_proceso; 
        this.activo=true;
        this.pedidos=pedidos;
    }
}
