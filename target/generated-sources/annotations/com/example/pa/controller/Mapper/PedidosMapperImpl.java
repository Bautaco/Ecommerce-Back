package com.example.pa.controller.Mapper;

import com.example.pa.controller.DTO.PedidosDTO.PedidosDTO;
import com.example.pa.model.Pedidos;
import com.example.pa.model.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-09T06:26:07-0300",
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
        List<Producto> list = pedidos.getProducto();
        if ( list != null ) {
            pedidosDTO.setProducto( new ArrayList<Producto>( list ) );
        }

        return pedidosDTO;
    }

    @Override
    public Pedidos toEntity(PedidosDTO pedidosDTO) {
        if ( pedidosDTO == null ) {
            return null;
        }

        Pedidos pedidos = new Pedidos();

        pedidos.setCliente( pedidosDTO.getCliente() );
        pedidos.setId( pedidosDTO.getId() );
        List<Producto> list = pedidosDTO.getProducto();
        if ( list != null ) {
            pedidos.setProducto( new ArrayList<Producto>( list ) );
        }
        pedidos.setEstado( pedidosDTO.getEstado() );
        pedidos.setActivo( pedidosDTO.isActivo() );

        return pedidos;
    }
}
