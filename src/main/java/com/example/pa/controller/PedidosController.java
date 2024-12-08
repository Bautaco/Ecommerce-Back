 package com.example.pa.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.pa.service.PedidosService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @Autowired
    private PedidosMapper pedidosMapper; // Inyectamos el mapper

    // Obtener todos los pedidos
    @GetMapping
    public ResponseEntity<List<PedidosDTO>> listarPedidos() {
        List<Pedidos> pedidos = pedidosService.findAll();

        // Convertir la lista de Pedidos a PedidosDTO usando el mapper
        List<PedidosDTO> pedidosDTO = pedidos.stream()
                                             .map(pedidosMapper::toDTO)
                                             .collect(Collectors.toList());

        return ResponseEntity.ok(pedidosDTO);
    }

    // Ver detalles de un pedido específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<PedidosDTO> obtenerDetallesPedido(@PathVariable Long id) {
        Pedidos pedido = pedidosService.findById(id);
        PedidosDTO pedidoDTO = pedidosMapper.toDTO(pedido);

        return ResponseEntity.ok(pedidoDTO);
    }

    // Actualizar el estado de un pedido
    @PutMapping("/{id}/estado")
    public ResponseEntity<PedidosDTO> actualizarEstadoPedido(
            @PathVariable Long id,
            @RequestParam String nuevoEstado) {
        try {
            // Llamar al servicio para actualizar el estado del pedido
            Pedidos pedidoActualizado = pedidosService.actualizarEstadoPedido(id, nuevoEstado);

            // Convertir el pedido actualizado a un PedidosDTO
            PedidosDTO pedidoDTO = pedidosMapper.toDTO(pedidoActualizado);

            // Retornar la respuesta con el DTO
            return ResponseEntity.ok(pedidoDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Manejar pedido no encontrado
        }
    }

    // Crear un nuevo pedido
    @PostMapping
    public ResponseEntity<PedidosDTO> crearPedido(@RequestBody PedidosDTO pedidosDTO) {
        // Convertir el DTO a la entidad Pedidos
        Pedidos pedido = pedidosMapper.toEntity(pedidosDTO);

        // Crear el pedido usando el servicio
        Pedidos pedidoCreado = pedidosService.crearPedidos(pedido.getId(), pedido.getProducto(), pedido.getCliente());

        // Convertir el pedido creado a un DTO
        PedidosDTO pedidoDTO = pedidosMapper.toDTO(pedidoCreado);

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoDTO);
    }

    // Eliminar un pedido de forma lógica (cambiar estado a no activo)
    @PutMapping("/{id}/eliminar")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
        try {
            pedidosService.eliminarPedidos(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // No hay contenido, eliminación exitosa
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Pedido no encontrado
        }
    }
    
}

