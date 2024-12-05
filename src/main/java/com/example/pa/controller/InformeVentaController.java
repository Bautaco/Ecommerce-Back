package com.example.pa.controller;

import com.example.pa.controller.DTO.InformesDTO.InformeVentaDTO;
import com.example.pa.service.InformeVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/informes")
public class InformeVentaController {

    @Autowired
    private InformeVentaService informeVentaService;

    @GetMapping("/ventas")
    public InformeVentaDTO generarInformeVentas(
            @RequestParam("fechaInicio") String fechaInicio,
            @RequestParam("fechaFin") String fechaFin) {
        LocalDate startDate = LocalDate.parse(fechaInicio);
        LocalDate endDate = LocalDate.parse(fechaFin);
        return informeVentaService.generarInformeVentas(startDate, endDate);
    }
}

