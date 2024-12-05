package com.example.pa.controller.Mapper;

import com.example.pa.controller.DTO.InformesDTO.InformeVentaDTO;
import com.example.pa.model.InformeVenta;

public class InformeVentaMapper {

    public static InformeVentaDTO toDTO(InformeVenta informeVenta) {
        InformeVentaDTO dto = new InformeVentaDTO();
        dto.setFechaInicio(informeVenta.getFechaInicio());
        dto.setFechaFin(informeVenta.getFechaFin());
        dto.setVentasTotales(informeVenta.getVentasTotales());
        dto.setNumeroPedidos(informeVenta.getNumeroPedidos());
        dto.setProductosMasVendidos(informeVenta.getProductosMasVendidos());
        return dto;
    }

    public static InformeVenta toEntity(InformeVentaDTO dto) {
        InformeVenta entity = new InformeVenta();
        entity.setFechaInicio(dto.getFechaInicio());
        entity.setFechaFin(dto.getFechaFin());
        entity.setVentasTotales(dto.getVentasTotales());
        entity.setNumeroPedidos(dto.getNumeroPedidos());
        entity.setProductosMasVendidos(dto.getProductosMasVendidos());
        return entity;
    }
}

