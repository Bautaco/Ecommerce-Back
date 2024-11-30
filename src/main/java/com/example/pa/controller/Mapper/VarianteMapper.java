package com.example.pa.controller.Mapper;

import com.example.pa.controller.DTO.VarianteDTO.VarianteDTO;
import com.example.pa.model.Variante;

public class VarianteMapper {
    
// Convierte de DTO a entidad
public static Variante toEntity(VarianteDTO dto) {
    Variante variante = new Variante();
    variante.setId(dto.getId());
    variante.setMaterial(dto.getMaterial());
    variante.setEstilo(dto.getEstilo());
    variante.setColor(dto.getColor());
    variante.setTalle(dto.getTalle());
    variante.setStock(dto.getStock());
    variante.setActivo(dto.isActivo());
    return variante;
}

// Convierte de entidad a DTO
public static VarianteDTO toDTO(Variante variante) {
    VarianteDTO dto = new VarianteDTO(null, null, null, null, null, 0, false, null);
    dto.setId(variante.getId());
    dto.setMaterial(variante.getMaterial());
    dto.setEstilo(variante.getEstilo());
    dto.setColor(variante.getColor());
    dto.setTalle(variante.getTalle());
    dto.setStock(variante.getStock());
    dto.setActivo(variante.isActivo());
    return dto;
}
}
