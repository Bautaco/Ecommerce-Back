package com.example.pa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pa.model.ProductoPedido;

@Repository
public interface ProductoPedidoRepository extends JpaRepository<ProductoPedido, Long> {

@Query("SELECT pp.producto.nombre, "+
       "SUM(pp.cantidad) AS cantidadVendida " +
       "FROM ProductoPedido pp " +
       "JOIN pp.pedido compra " +
       "WHERE compra.fechaCreacion BETWEEN :fechaInicio AND :fechaFin " + // Parámetros para el rango de fechas
       "GROUP BY pp.producto.nombre " +
       "ORDER BY cantidadVendida DESC")
List<Object[]> obtenerProductosMasVendidos(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);




    ///////////////////////consuta para fran
//     SELECT 
//     compra.fecha_creacion::date AS fecha, 
//     producto.nombre AS producto, 
//     SUM(detalle.cantidad) AS total_vendido
// FROM public.producto_pedido AS detalle
// INNER JOIN public.pedidos AS compra ON detalle.pedido_id = compra.id
// INNER JOIN public.producto ON detalle.producto_id = public.producto.id
// GROUP BY fecha, producto.nombre
// ORDER BY total_vendido DESC;   





@Query("SELECT pp.producto.nombre, pp.producto.precio, SUM(pp.cantidad) as cantidadVendida, " +
       "SUM(pp.producto.precio * pp.cantidad) as totalVendido " +
       "FROM ProductoPedido pp " +
       "JOIN pp.pedido compra " + 
       "WHERE compra.fechaCreacion BETWEEN :fechaInicio AND :fechaFin " + // Filtrar por fecha
       "GROUP BY pp.producto.nombre, pp.producto.precio " +
       "ORDER BY totalVendido DESC")
List<Object[]> obtenerProductosMasVendidosxPrecio(@Param("fechaInicio") LocalDateTime fechaInicio, 
                                                 @Param("fechaFin") LocalDateTime fechaFin);

}