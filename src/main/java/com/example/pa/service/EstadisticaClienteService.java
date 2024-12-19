package com.example.pa.service;


import com.example.pa.model.EstadisticaCliente;
import com.example.pa.repository.EstadisticaClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EstadisticaClienteService {

    @Autowired
    private EstadisticaClienteRepository estadisticaClienteRepository;

    public List<EstadisticaCliente> findByUserAndFechaCompraBetween(Long userId, LocalDate fechaInicio, LocalDate fechaFin) {
        return estadisticaClienteRepository.findByUserIdAndFechaCompraBetween(userId, fechaInicio, fechaFin);
    }
}

