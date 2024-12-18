
//  package com.example.pa.controller.Mapper;

//  import org.mapstruct.Mapper;

//  import com.example.pa.controller.DTO.PedidosDTO.PedidosDTO;
//  import com.example.pa.model.Pedidos;

//  @Mapper(componentModel = "spring")
//  public interface PedidosMapper {

//      PedidosDTO toDTO(Pedidos pedidos);

//      Pedidos toEntity(PedidosDTO pedidosDTO);
//  }
 //--------------------------------------------------------------------------------//
 package com.example.pa.controller.Mapper;

 import java.util.List;

 import org.mapstruct.Mapper;
 import org.mapstruct.Mapping;

 import com.example.pa.controller.DTO.PedidosDTO.PedidosDTO;
 import com.example.pa.controller.DTO.ProductoDTO.ProductoDTO;
 import com.example.pa.model.Pedidos;
 import com.example.pa.model.Producto;

 @Mapper(componentModel = "spring")
 public interface PedidosMapper {

     @Mapping(source = "producto", target = "producto") // Aseguramos que los productos sean mapeados
     PedidosDTO toDTO(Pedidos pedidos);

     @Mapping(source = "producto", target = "producto")
     Pedidos toEntity(PedidosDTO pedidosDTO);

     // Métodos adicionales para mapear listas o productos individuales si es necesario
     List<Producto> toProductoList(List<Producto> productos);

     List<ProductoDTO> toProductoDTOList(List<Producto> productos);
 }
