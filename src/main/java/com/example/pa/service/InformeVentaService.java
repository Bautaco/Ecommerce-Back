package com.example.pa.service;

import com.example.pa.controller.DTO.InformesDTO.InformeVentaDTO;
import com.example.pa.model.InformeVenta;
import com.example.pa.repository.InformeVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InformeVentaService {

    @Autowired
    private InformeVentaRepository informeVentasRepository;

    public InformeVentaDTO generarInformeVentas(LocalDate fechaInicio, LocalDate fechaFin) {
        List<InformeVenta> informes = informeVentasRepository.findByFechaInicioBetween(fechaInicio, fechaFin);
        double ventasTotales = informes.stream().mapToDouble(InformeVenta::getVentasTotales).sum();
        int numeroPedidos = informes.stream().mapToInt(InformeVenta::getNumeroPedidos).sum();
        String productosMasVendidos = "TODO: Productos más vendidos"; // Implementar lógica

        return new InformeVentaDTO(fechaInicio, fechaFin, ventasTotales, numeroPedidos, productosMasVendidos);
    }
}
