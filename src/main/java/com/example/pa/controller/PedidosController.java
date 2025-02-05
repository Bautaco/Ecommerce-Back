package com.example.pa.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pa.controller.DTO.PedidosDTO.ActualizarEstadoDTO;
import com.example.pa.controller.DTO.PedidosDTO.AgregarProductosDTO;
import com.example.pa.controller.DTO.PedidosDTO.CrearPedidoDTO;
import com.example.pa.controller.DTO.PedidosDTO.PedidosDTO;
import com.example.pa.controller.Mapper.CrearPedidoMapper;
import com.example.pa.controller.Mapper.PedidosMapper;
import com.example.pa.model.Pedidos;
import com.example.pa.model.ProductoPedido;
import com.example.pa.service.PedidosService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

     @Autowired
    private PedidosService pedidoService;

    @Autowired
    private PedidosMapper pedidoMapper;

    @Autowired
    private CrearPedidoMapper crearPedidoMapper;

    // Crear un nuevo pedido
    @PostMapping
    public ResponseEntity<PedidosDTO> crearPedido(@RequestBody CrearPedidoDTO crearPedidoDTO) {
        // Convertir DTO a entidad
        Pedidos pedido = crearPedidoMapper.toEntity(crearPedidoDTO);

        // Agregar productos al pedido
        List<ProductoPedido> productoPedidos = crearPedidoMapper.toProductoPedidoList(
                crearPedidoDTO,
                pedidoService.obtenerProductosPorId(crearPedidoDTO.getProductos().stream()
                        .map(AgregarProductosDTO::getProductoId)
                        .collect(Collectors.toList()))
        );

        productoPedidos.forEach(pedido::agregarProducto);

        // Guardar el pedido
        Pedidos pedidoGuardado = pedidoService.guardarPedido(pedido);

        // Convertir a DTO para la respuesta
        PedidosDTO pedidoDTO = pedidoMapper.toDTO(pedidoGuardado);

        return ResponseEntity.ok(pedidoDTO);
    }

    // Agregar productos a un pedido
    @PostMapping("/{pedidoId}/productos")
    public ResponseEntity<PedidosDTO> agregarProducto(
            @PathVariable Long pedidoId,
            @RequestBody AgregarProductosDTO agregarProductoDTO) {

        Pedidos pedido = pedidoService.agregarProducto(pedidoId, agregarProductoDTO.getProductoId(), agregarProductoDTO.getCantidad());
        return ResponseEntity.ok(pedidoMapper.toDTO(pedido));
    }

     // Eliminar productos de un pedido
     @DeleteMapping("/{pedidoId}/productos/{productoPedidoId}")
     public ResponseEntity<PedidosDTO> eliminarProducto(
             @PathVariable Long pedidoId,
             @PathVariable Long productoPedidoId) {
 
         Pedidos pedido = pedidoService.eliminarProducto(pedidoId, productoPedidoId);
         return ResponseEntity.ok(pedidoMapper.toDTO(pedido));
     }

    // Obtener todos los pedidos
    @GetMapping
    public ResponseEntity<List<PedidosDTO>> obtenerTodosLosPedidos() {
        List<Pedidos> pedidos = pedidoService.obtenerTodosLosPedidos();
        List<PedidosDTO> pedidosDTO = pedidos.stream()
                .map(pedidoMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pedidosDTO);
    }

    // Obtener pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<PedidosDTO> obtenerPedidoPorId(@PathVariable Long id) {
        return pedidoService.obtenerPedidoPorId(id)
                .map(pedido -> ResponseEntity.ok(pedidoMapper.toDTO(pedido)))
                .orElse(ResponseEntity.notFound().build());
    }


    // Actualizar estado de un pedido
    @PutMapping("/{id}/estado")
    public ResponseEntity<PedidosDTO> actualizarEstado(
            @PathVariable Long id,
            @RequestBody ActualizarEstadoDTO actualizarEstadoDTO) {

        Pedidos pedido = pedidoService.actualizarEstado(id, Pedidos.Estado.valueOf(actualizarEstadoDTO.getEstado()));
        return ResponseEntity.ok(pedidoMapper.toDTO(pedido));
    }
}
