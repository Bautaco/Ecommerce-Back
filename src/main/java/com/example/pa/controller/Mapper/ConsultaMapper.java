package com.example.pa.controller.Mapper;

import org.mapstruct.*;

import com.example.pa.controller.DTO.ConsultaDTO.ConsultaDTO;
import com.example.pa.model.Consulta;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

    @Mapping(target = "fechaEnvio", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "estado", constant = "Pendiente")
    Consulta toEntity(ConsultaDTO dto);

    ConsultaDTO toDTO(Consulta consulta);
}
