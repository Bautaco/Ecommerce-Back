package com.example.pa.controller.Mapper;

import com.example.pa.controller.DTO.MarcaDTO.MarcaDTO;
import com.example.pa.model.Marca;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-03T21:47:55-0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class MarcaMapperImpl implements MarcaMapper {

    @Override
    public MarcaDTO toDTO(Marca marca) {
        if ( marca == null ) {
            return null;
        }

        boolean activo = false;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        activo = marca.isActivo();
        id = marca.getId();
        nombre = marca.getNombre();
        descripcion = marca.getDescripcion();

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
