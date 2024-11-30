package com.example.pa.controller.Mapper;

import com.example.pa.controller.DTO.SubCategoriaDTO.SubCategoriaDTO;
import com.example.pa.model.SubCategoria;

public class SubCategoriaMapper {
    
     // Convierte de DTO a entidad
     public static SubCategoria toEntity(SubCategoriaDTO dto) {
        SubCategoria subcategoria = new SubCategoria();
        subcategoria.setId(dto.getId());
        subcategoria.setNombre(dto.getNombre());
        subcategoria.setActivo(dto.isActivo());
        return subcategoria;
    }

    // Convierte de entidad a DTO
    public static SubCategoriaDTO toDTO(SubCategoria subcategoria) {
        SubCategoriaDTO dto = new SubCategoriaDTO(null, null, false, null, null);
        dto.setId(subcategoria.getId());
        dto.setNombre(subcategoria.getNombre());
        dto.setActivo(subcategoria.isActivo());
        return dto;
    }
}
