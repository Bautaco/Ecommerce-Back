package com.example.pa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pa.model.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
    //Categorías Activas
    List<Pedidos> findByActivoTrue();

    //Categorías Inactivas
    List<Pedidos> findByActivoFalse();

}
