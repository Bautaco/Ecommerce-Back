package com.example.pa.controller.Mapper;

import com.example.pa.controller.DTO.ConsultaDTO.ConsultaDTO;
import com.example.pa.model.Consulta;
import com.example.pa.model.EstadoConsulta;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-04T21:32:21-0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.40.0.z20241112-1021, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class ConsultaMapperImpl implements ConsultaMapper {

    @Override
    public Consulta toEntity(ConsultaDTO ConsultaDTO) {
        if ( ConsultaDTO == null ) {
            return null;
        }

        String descripcion = null;

        descripcion = ConsultaDTO.getDescripcion();

        EstadoConsulta estado = EstadoConsulta.valueOf(dto.getEstado().toUpperCase());
        Long id = null;
        LocalDateTime fechaEnvio = null;
        List<String> archivosAdjuntos = null;

        Consulta consulta = new Consulta( id, descripcion, fechaEnvio, estado, archivosAdjuntos );

        return consulta;
    }

    @Override
    public ConsultaDTO toDTO(Consulta Consulta) {
        if ( Consulta == null ) {
            return null;
        }

        String descripcion = null;

        descripcion = Consulta.getDescripcion();

        EstadoConsulta estado = consulta.getEstado().toString();
        List<MultipartFile> archivos = null;

        ConsultaDTO consultaDTO = new ConsultaDTO( descripcion, estado, archivos );

        return consultaDTO;
    }
}
