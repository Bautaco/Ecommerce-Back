package com.example.pa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pa.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
    // Método para buscar stock por el ID del producto
    Stock findByProductoId(Long productoId);
}

