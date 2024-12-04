package com.example.pa.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Setter
@Getter
@ToString(exclude = "producto")
public class Pedidos {

   
    public enum Estado{En_proceso,Enviado,Completado}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean activo =true;
    private Estado estado;
    //usuario Cliente;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)

    private List<Producto> producto = new ArrayList<>();

    public Pedidos() {
    }
    public Pedidos(long ID, List<Producto> listaProducto /*, Usuario cliente*/){
        //TODO traer usuario
        //this.cliente=cliente;
        this.id=ID;
        this.producto=listaProducto;
        this.estado = Estado.En_proceso; 
        this.activo=true;
    }
    public void setEstado(Estado estadoValido) {
        this.estado=estadoValido;
    }
    
    public void eliminarProducto(long idProducto) {
        producto.removeIf(producto -> producto.getId().equals(idProducto));
    }

    public double getTotal() {
        return producto.stream().mapToDouble(p -> p.getPrecio() * p.getStock()).sum();
    }

    public void agregarProducto(Producto producto)  //agrega un producto a la compra
    {
        producto.add(producto);
    }
    public void setActivo(boolean b) {
        this.activo=b;
    }
}