package com.example.pa.controller.Mapper;

import com.example.pa.controller.DTO.MarcaDTO.MarcaDTO;
import com.example.pa.model.Marca;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-16T13:44:38-0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.40.0.z20241112-1021, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class MarcaMapperImpl implements MarcaMapper {

    @Override
    public MarcaDTO toDTO(Marca marca) {
        if ( marca == null ) {
            return null;
        }

        boolean activo = false;
        String descripcion = null;
        Long id = null;
        String nombre = null;

        activo = marca.isActivo();
        descripcion = marca.getDescripcion();
        id = marca.getId();
        nombre = marca.getNombre();

        MarcaDTO marcaDTO = new MarcaDTO( id, nombre, descripcion, activo );

        return marcaDTO;
    }

    @Override
    public Marca toEntity(MarcaDTO marcaDTO) {
        if ( marcaDTO == null ) {
            return null;
        }

        Marca marca = new Marca();

        marca.setActivo( marcaDTO.isActivo() );
        marca.setDescripcion( marcaDTO.getDescripcion() );
        marca.setId( marcaDTO.getId() );
        marca.setNombre( marcaDTO.getNombre() );

        return marca;
    }
}
