package com.example.pa.repository;

import com.example.pa.model.InformeVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface InformeVentaRepository extends JpaRepository<InformeVenta, Long> {

    List<InformeVenta> findByFechaInicioBetween(LocalDate fechaInicio, LocalDate fechaFin);

    // Puedes agregar otros métodos para consultas más específicas
}
