package com.example.pa.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pa.controller.DTO.PedidosDTO.PedidosDTO;
import com.example.pa.model.Pedidos;
import com.example.pa.service.PedidosService;



@RestController
@RequestMapping("/api/Pedidos")
public class PedidosController {
    @Autowired
    private PedidosService pedidosService;
    

    // 1. Obtener todos los pedidos para el panel de administración
    @GetMapping
    public ResponseEntity<List<PedidosDTO>> listarPedidos() {
        List<Pedidos> pedidos = pedidosService.findAll();
    
        // Mapeamos manualmente cada Pedidos a PedidosDTO
        List<PedidosDTO> pedidosDTO = pedidos.stream()
                                             .map(pedido -> new PedidosDTO(
                                                 pedido.getId(), // ID
                                                 pedido.getProducto(), // Lista de productos
                                                 pedido // Objeto Pedidos completo
                                             ))
                                             .collect(Collectors.toList());
    
        return ResponseEntity.ok(pedidosDTO);
    }
    


    // 2. Ver detalles de un pedido específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<PedidosDTO> obtenerDetallesPedido(@PathVariable Long id) {
        // Buscar el pedido por ID
        Pedidos detalles = pedidosService.findById(id);
    
        // Convertir el objeto Pedidos a PedidosDTO
        PedidosDTO detallesDTO = new PedidosDTO(
            detalles.getId(), 
            detalles.getProducto(), 
            detalles // Pasar el objeto completo si es necesario
        );
    
        // Devolver la respuesta
        return ResponseEntity.ok(detallesDTO);
    }
    

    // 3. Actualizar el estado de un pedido
@PutMapping("/{id}/estado")
public ResponseEntity<PedidosDTO> actualizarEstadoPedido(
        @PathVariable Long id,
        @RequestParam String nuevoEstado) {
    try {
        // Llamar al servicio para actualizar el estado del pedido
        Pedidos pedidoActualizado = pedidosService.actualizarEstadoPedido(id, nuevoEstado);

        // Convertir el pedido actualizado a un PedidosDTO
        PedidosDTO pedidoDTO = new PedidosDTO(
                pedidoActualizado.getId(),
                pedidoActualizado.getProducto(),
                pedidoActualizado
        );

        // Retornar la respuesta con el DTO
        return ResponseEntity.ok(pedidoDTO);
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Manejar pedido no encontrado
    }
}


    // // 4. Obtener historial de pedidos de un cliente específico (opcional)
    // @GetMapping("/cliente/{clienteId}")
    // public ResponseEntity<List<PedidoDTO>> obtenerHistorialPedidos(@PathVariable Long clienteId) {
    //     List<Pedidos> historial = pedidosService.obtenerHistorialPedidos(clienteId);
    //     return ResponseEntity.ok(historial);
    // }
}
