package com.example.pa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pa.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    //Listado solo productos activos
    List<Producto> findByActivoTrue();
    
    //Listados solo productos inactivos
    List<Producto> findByActivoFalse();


    // Consulta para obtener productos con stock bajo
    List<Producto> findByStockLessThanAndActivoTrue(int umbralStockBajo);
    
    // Consulta para encontrar un producto por su ID
    Optional<Producto> findById(Long id);
    
}

