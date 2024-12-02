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
@ToString(exclude = "productos")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean activo =true;

    public enum Estado{Inicializado,Finalizado,Pendiente}

    private Estado estado;

    //usuario Cliente;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)

    private List<Producto> productos = new ArrayList<>();

    public Compra() {
    }

    public void eliminarProducto(long idProducto) {
        productos.removeIf(producto -> producto.getId().equals(idProducto));
    }

    public double getTotal() {
        return productos.stream().mapToDouble(p -> p.getPrecio() * p.getStock()).sum();
    }

    public void agregarProducto(Producto producto)  //agrega un producto a la compra
    {
        productos.add(producto);
    }

    public Compra(long ID, List<Producto> listaProducto /*, Usuario cliente*/){
        //TODO traer usuario
        this.id=ID;
        this.productos=listaProducto;
        this.estado = Estado.Inicializado; 
        //this.cliente=cliente;
        this.activo=true;
    }


}