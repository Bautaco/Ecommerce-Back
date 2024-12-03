package com.example.pa.repository;

import com.example.pa.model.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PromocionRepository extends JpaRepository<Promocion, Long> {
    List<Promocion> findByActivaTrueAndFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(LocalDate start, LocalDate end);
}
