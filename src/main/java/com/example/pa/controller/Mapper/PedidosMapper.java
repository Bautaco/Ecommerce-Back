package com.example.pa.controller.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.example.pa.controller.DTO.PedidosDTO.PedidosDTO;
import com.example.pa.model.Pedidos;
import com.example.pa.model.Producto;

public class PedidosMapper {

    // Mapeo de Pedidos a PedidosDTO
    public static PedidosDTO toDTO(Pedidos pedido) {
        List<Producto> productos = pedido.getProducto();
        return new PedidosDTO(
                pedido.getId(),
                productos,
                pedido.getEstado(),
                pedido.isActivo(),
                pedido.getCliente()
        );
    }

    // Mapeo de PedidosDTO a Pedidos
    public static Pedidos toEntity(PedidosDTO pedidosDTO, List<Producto> productos) {
        Pedidos pedido = new Pedidos();
        pedido.setId(pedidosDTO.getId());
        pedido.setProducto(productos);
        pedido.setEstado(pedidosDTO.getEstado());
        pedido.setActivo(pedidosDTO.isActivo());
        pedido.setCliente(pedidosDTO.getCliente());
        return pedido;
    }

    // Mapeo de una lista de Pedidos a una lista de PedidosDTO
    public static List<PedidosDTO> toDTOList(List<Pedidos> pedidosList) {
        return pedidosList.stream()
                .map(PedidosMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Mapeo de una lista de PedidosDTO a una lista de Pedidos
    public static List<Pedidos> toEntityList(List<PedidosDTO> pedidosDTOList, List<List<Producto>> productosList) {
        return pedidosDTOList.stream()
                .map(dto -> toEntity(dto, productosList.get(pedidosDTOList.indexOf(dto))))
                .collect(Collectors.toList());
    }
}

 //--------------------------------------------------------------------------------//
//  package com.example.pa.controller.Mapper;

//  import java.util.List;

//  import org.mapstruct.Mapper;
//  import org.mapstruct.Mapping;

//  import com.example.pa.controller.DTO.PedidosDTO.PedidosDTO;
//  import com.example.pa.controller.DTO.ProductoDTO.ProductoDTO;
//  import com.example.pa.model.Pedidos;
//  import com.example.pa.model.Producto;

//  @Mapper(componentModel = "spring")
//  public interface PedidosMapper {

//      @Mapping(source = "producto", target = "producto") // Aseguramos que los productos sean mapeados
//      PedidosDTO toDTO(Pedidos pedidos);

//      @Mapping(source = "producto", target = "producto")
//      Pedidos toEntity(PedidosDTO pedidosDTO);

//      // Métodos adicionales para mapear listas o productos individuales si es necesario
//      List<Producto> toProductoList(List<Producto> productos);

//      List<ProductoDTO> toProductoDTOList(List<Producto> productos);
//  }
