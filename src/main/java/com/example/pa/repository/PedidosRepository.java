package com.example.pa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pa.model.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
    //Categorías Activas
    List<Pedidos> findByActivoTrue();

    //Categorías Inactivas
    List<Pedidos> findByActivoFalse();

    @Modifying
    @Query("UPDATE Pedidos p SET p.estado = :nuevoEstado WHERE p.id = :id")
    int updateEstadoPedido(Long id, String nuevoEstado);

    @Query("SELECT SUM(pp.subtotal) FROM ProductoPedido pp WHERE pp.pedido.estado = com.example.pa.model.Pedidos.Estado.Completado AND pp.pedido.fechaCreacion BETWEEN :fechaInicio AND :fechaFin")
    Double calcularVentasTotales(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);

    @Query("SELECT COUNT(p) FROM Pedidos p WHERE p.estado = com.example.pa.model.Pedidos.Estado.Completado AND p.fechaCreacion BETWEEN :fechaInicio AND :fechaFin")
    Long contarPedidosEntreFechas(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);
   
    
    // @Query("SELECT FROM Pedidos p WHERE p.estado = com.example.pa.model.Pedidos.Estado.Completado AND p.fechaCreacion BETWEEN :fechaInicio AND :fechaFin")
    @Query("SELECT p FROM Pedidos p WHERE p.estado = com.example.pa.model.Pedidos.Estado.Completado AND p.fechaCreacion BETWEEN :fechaInicio AND :fechaFin")
    List<Pedidos> pedidosporfecha(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);
    // List<Pedidos> findByFechaPedidoBetween(LocalDate fechaInicio, LocalDate fechaFin);
}