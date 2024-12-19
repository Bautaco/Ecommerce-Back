package com.example.pa.repository;


import com.example.pa.model.EstadisticaCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface EstadisticaClienteRepository extends JpaRepository<EstadisticaCliente, Long> {
    List<EstadisticaCliente> findByUserIdAndFechaCompraBetween(Long userId, LocalDate fechaInicio, LocalDate fechaFin);
}


