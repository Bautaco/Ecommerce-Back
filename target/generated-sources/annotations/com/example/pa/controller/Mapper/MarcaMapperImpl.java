package com.example.pa.controller.Mapper;

import com.example.pa.controller.DTO.MarcaDTO.MarcaDTO;
import com.example.pa.model.Marca;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-09T06:26:07-0300",
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

        Long id = null;
        String nombre = null;
        String descripcion = null;
        boolean activo = false;

        id = marcaDTO.getId();
        nombre = marcaDTO.getNombre();
        descripcion = marcaDTO.getDescripcion();
        activo = marcaDTO.isActivo();

        Marca marca = new Marca( id, nombre, descripcion, activo );

        return marca;
    }
}
