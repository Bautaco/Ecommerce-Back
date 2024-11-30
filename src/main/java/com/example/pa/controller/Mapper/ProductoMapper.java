package com.example.pa.controller.Mapper;

import com.example.pa.controller.DTO.ProductoDTO.ProductoDTO;
import com.example.pa.model.Producto;


public interface ProductoMapper {
   
    ProductoDTO productoToProductoDTO(Producto producto);
    Producto productoDTOToProducto(ProductoDTO productoDTO);

}

