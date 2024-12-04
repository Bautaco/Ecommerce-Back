package com.example.pa.controller.Mapper;

import org.mapstruct.*;

import com.example.pa.controller.DTO.ConsultaDTO.ConsultaDTO;
import com.example.pa.model.Consulta;
import com.example.pa.model.EstadoConsulta;

@Mapper(componentModel = "spring", imports = EstadoConsulta.class)
public interface ConsultaMapper {

    @Mapping(target = "estado", expression = "java(EstadoConsulta.valueOf(dto.getEstado().toUpperCase()))")
    Consulta toEntity(ConsultaDTO ConsultaDTO);

    @Mapping(target = "estado", expression = "java(consulta.getEstado().toString())")
    ConsultaDTO toDTO(Consulta Consulta);
}
