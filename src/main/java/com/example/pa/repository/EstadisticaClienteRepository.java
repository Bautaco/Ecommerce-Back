package com.example.pa.repository;

import com.example.pa.model.EstadisticaCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadisticaClienteRepository extends JpaRepository<EstadisticaCliente, Long> {

    List<EstadisticaCliente> findByClienteId(Long clienteId);
    // Otras consultas según las necesidades
}
