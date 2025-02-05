package com.example.pa.controller.Mapper;

import com.example.pa.controller.DTO.ConsultaDTO.ConsultaDTO;
import com.example.pa.model.Consulta;
import com.example.pa.model.EstadoConsulta;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-03T21:47:56-0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class ConsultaMapperImpl implements ConsultaMapper {

    @Override
    public Consulta toEntity(ConsultaDTO ConsultaDTO) {
        if ( ConsultaDTO == null ) {
            return null;
        }

        Consulta consulta = new Consulta();

        consulta.setDescripcion( ConsultaDTO.getDescripcion() );

        consulta.setEstado( EstadoConsulta.valueOf(dto.getEstado().toUpperCase()) );

        return consulta;
    }

    @Override
    public ConsultaDTO toDTO(Consulta Consulta) {
        if ( Consulta == null ) {
            return null;
        }

        ConsultaDTO consultaDTO = new ConsultaDTO();

        consultaDTO.setDescripcion( Consulta.getDescripcion() );

        consultaDTO.setEstado( consulta.getEstado().toString() );

        return consultaDTO;
    }
}
