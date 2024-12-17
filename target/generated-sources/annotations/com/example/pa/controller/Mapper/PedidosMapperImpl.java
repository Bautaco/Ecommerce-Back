package com.example.pa.controller.Mapper;

import com.example.pa.controller.DTO.PedidosDTO.PedidosDTO;
import com.example.pa.model.Pedidos;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-16T22:08:01-0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.40.0.z20241112-1021, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class PedidosMapperImpl implements PedidosMapper {

    @Override
    public PedidosDTO toDTO(Pedidos pedidos) {
        if ( pedidos == null ) {
            return null;
        }

        PedidosDTO pedidosDTO = new PedidosDTO();

        pedidosDTO.setActivo( pedidos.isActivo() );
        pedidosDTO.setCliente( pedidos.getCliente() );
        pedidosDTO.setEstado( pedidos.getEstado() );
        if ( pedidos.getId() != null ) {
            pedidosDTO.setId( pedidos.getId() );
        }

        return pedidosDTO;
    }

    @Override
    public Pedidos toEntity(PedidosDTO pedidosDTO) {
        if ( pedidosDTO == null ) {
            return null;
        }

        Pedidos pedidos = new Pedidos();

        pedidos.setActivo( pedidosDTO.isActivo() );
        pedidos.setCliente( pedidosDTO.getCliente() );
        pedidos.setEstado( pedidosDTO.getEstado() );
        pedidos.setId( pedidosDTO.getId() );

        return pedidos;
    }
}
