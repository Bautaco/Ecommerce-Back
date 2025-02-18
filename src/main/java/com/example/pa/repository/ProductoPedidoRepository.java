package com.example.pa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pa.model.ProductoPedido;

@Repository
public interface ProductoPedidoRepository extends JpaRepository<ProductoPedido, Long> {

    @Query("SELECT pp.producto.nombre, SUM(pp.cantidad) as cantidadVendida FROM ProductoPedido pp GROUP BY pp.producto.nombre ORDER BY cantidadVendida DESC")
    List<Object[]> obtenerProductosMasVendidos();

    @Query("SELECT pp.producto.nombre, pp.producto.precio, SUM(pp.cantidad) as cantidadVendida, " +
       "SUM(pp.producto.precio * pp.cantidad) as totalVendido " +
       "FROM ProductoPedido pp " +
       "GROUP BY pp.producto.nombre, pp.producto.precio " +
       "ORDER BY totalVendido DESC")
    List<Object[]> obtenerProductosMasVendidosxPrecio();

}