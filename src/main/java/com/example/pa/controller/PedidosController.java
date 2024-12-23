package com.example.pa.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pa.controller.DTO.PedidosDTO.PedidosDTO;
import com.example.pa.controller.Mapper.PedidosMapper;
import com.example.pa.model.Pedidos;
import com.example.pa.model.Producto;
import com.example.pa.service.PedidosService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    // Crear un nuevo pedido
    @PostMapping
    public ResponseEntity<PedidosDTO> crearPedido(@RequestBody PedidosDTO pedidosDTO) {
        try {
            // Convertir el DTO a la entidad Pedidos (usando el mapeo manual)
            Pedidos pedido = PedidosMapper.toEntity(pedidosDTO, pedidosDTO.getProducto());

            // Crear el pedido usando el servicio
            Pedidos pedidoCreado = pedidosService.crearPedidos(pedido.getId(), pedido.getProducto(), pedido.getCliente());

            // Convertir el pedido creado a un DTO (usando el mapeo manual)
            PedidosDTO pedidoDTO = PedidosMapper.toDTO(pedidoCreado);

            return ResponseEntity.status(HttpStatus.CREATED).body(pedidoDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Obtener todos los pedidos
    @GetMapping
    public ResponseEntity<List<PedidosDTO>> listarPedidos() {
        List<Pedidos> pedidos = pedidosService.findAll();

        // Convertir la lista de Pedidos a PedidosDTO usando el mapeo manual
        List<PedidosDTO> pedidosDTO = pedidos.stream()
                                             .map(PedidosMapper::toDTO)
                                             .collect(Collectors.toList());

        return ResponseEntity.ok(pedidosDTO);
    }

    // Ver detalles de un pedido específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<PedidosDTO> obtenerDetallesPedido(@PathVariable Long id) {
        Pedidos pedido = pedidosService.findById(id);

        // Convertir el pedido a un DTO usando el mapeo manual
        PedidosDTO pedidoDTO = PedidosMapper.toDTO(pedido);

        return ResponseEntity.ok(pedidoDTO);
    }

    @PutMapping("/{id}/estado")
public ResponseEntity<PedidosDTO> cambiarEstadoPedido(
        @PathVariable Long id,
        @RequestParam Pedidos.Estado estado) {
    try {
        // Cambiar el estado del pedido usando el servicio
        Pedidos pedidoActualizado = pedidosService.cambiarEstado(id, estado);

        // Convertir el pedido actualizado a un DTO
        PedidosDTO pedidoDTO = PedidosMapper.toDTO(pedidoActualizado);

        return ResponseEntity.ok(pedidoDTO);
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Manejar pedido no encontrado
    }
}

    // Eliminar un producto de la lista de un pedido
    @DeleteMapping("/{id}/productos/{productoId}")
    public ResponseEntity<PedidosDTO> eliminarProductoDePedido(
            @PathVariable Long id,
            @PathVariable Long productoId) {
        try {
            // Llamar al servicio para eliminar el producto
            Pedidos pedidoActualizado = pedidosService.eliminarProducto(id, productoId);

            // Convertir el pedido actualizado a un PedidosDTO
            PedidosDTO pedidoDTO = PedidosMapper.toDTO(pedidoActualizado);

            return ResponseEntity.ok(pedidoDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Manejar pedido o producto no encontrado
        }
    }

    // Recuperar un pedido eliminado (revertir eliminación lógica)
    @PutMapping("/{id}/recuperar")
    public ResponseEntity<PedidosDTO> recuperarPedido(@PathVariable Long id) {
        try {
            Pedidos pedidoRecuperado = pedidosService.recuperarPedido(id);

            // Convertir el pedido recuperado a un PedidosDTO
            PedidosDTO pedidoDTO = PedidosMapper.toDTO(pedidoRecuperado);

            return ResponseEntity.ok(pedidoDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Manejar pedido no encontrado
        }
    }

    // Agregar un producto a un pedido
    @PostMapping("/{id}/productos")
    public ResponseEntity<PedidosDTO> agregarProducto(
            @PathVariable Long id,
            @RequestBody Producto producto) {
        Pedidos pedidoActualizado = pedidosService.agregarProducto(id, producto);

        // Convertir el pedido actualizado a un PedidosDTO
        PedidosDTO pedidoDTO = PedidosMapper.toDTO(pedidoActualizado);

        return ResponseEntity.ok(pedidoDTO);
    }

    // Eliminar un pedido (eliminación lógica)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
        try {
            pedidosService.eliminarPedidos(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Respuesta sin contenido
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Pedido no encontrado
        }
    }
}
