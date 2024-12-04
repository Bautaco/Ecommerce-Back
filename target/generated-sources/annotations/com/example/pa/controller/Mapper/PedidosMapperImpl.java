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
    date = "2024-12-04T02:49:36-0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.40.0.z20241112-1021, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class PedidosMapperImpl implements PedidosMapper {

    @Override
    public PedidosDTO toDO(Pedidos pedidos) {
        if ( pedidos == null ) {
            return null;
        }

        PedidosDTO pedidosDTO = new PedidosDTO();

        pedidosDTO.setActivo( pedidos.isActivo() );
        pedidosDTO.setEstado( pedidos.getEstado() );
        if ( pedidos.getId() != null ) {
            pedidosDTO.setId( pedidos.getId() );
        }
        List<Producto> list = pedidos.getProductos();
        if ( list != null ) {
            pedidosDTO.setProductos( new ArrayList<Producto>( list ) );
        }

        return pedidosDTO;
    }

    @Override
    public Pedidos toEmtity(PedidosDTO pedidosDTO) {
        if ( pedidosDTO == null ) {
            return null;
        }

        Pedidos pedidos = new Pedidos();

        pedidos.setActivo( pedidosDTO.isActivo() );
        pedidos.setEstado( pedidosDTO.getEstado() );
        pedidos.setId( pedidosDTO.getId() );
        List<Producto> list = pedidosDTO.getProductos();
        if ( list != null ) {
            pedidos.setProductos( new ArrayList<Producto>( list ) );
        }

        return pedidos;
    }
}
