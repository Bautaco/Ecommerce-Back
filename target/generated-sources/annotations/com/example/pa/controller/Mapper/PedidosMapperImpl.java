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
    date = "2024-12-16T13:44:37-0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.40.0.z20241112-1021, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class PedidosMapperImpl implements PedidosMapper {

    @Override
    public PedidosDTO toDTO(Pedidos pedidos) {
        if ( pedidos == null ) {
            return null;
        }

        boolean activo = false;
        long cliente = 0L;
        Pedidos.Estado estado = null;
        long id = 0L;
        List<Producto> producto = null;

        activo = pedidos.isActivo();
        cliente = pedidos.getCliente();
        estado = pedidos.getEstado();
        if ( pedidos.getId() != null ) {
            id = pedidos.getId();
        }
        List<Producto> list = pedidos.getProducto();
        if ( list != null ) {
            producto = new ArrayList<Producto>( list );
        }

        PedidosDTO pedidosDTO = new PedidosDTO( id, producto, estado, activo, cliente );

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
        List<Producto> list = pedidosDTO.getProducto();
        if ( list != null ) {
            pedidos.setProducto( new ArrayList<Producto>( list ) );
        }

        return pedidos;
    }
}
