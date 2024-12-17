<<<<<<< HEAD
 package com.example.pa.controller;

// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.pa.controller.DTO.PedidosDTO.PedidosDTO;
// import com.example.pa.model.Pedidos;
// import com.example.pa.service.PedidosService;



// @RestController
// @RequestMapping("/api/Pedidos")
// public class PedidosController {
//     @Autowired
//     private PedidosService pedidosService;
    

//     // 1. Obtener todos los pedidos para el panel de administración
//     @GetMapping
//     public ResponseEntity<List<PedidosDTO>> listarPedidos() {
//         List<Pedidos> pedidos = pedidosService.findAll();
    
//         // Mapeamos manualmente cada Pedidos a PedidosDTO
//         List<PedidosDTO> pedidosDTO = pedidos.stream()
//                                              .map(pedido -> new PedidosDTO(
//                                                  pedido.getId(), // ID
//                                                  pedido.getProducto(), // Lista de productos
//                                                  pedido // Objeto Pedidos completo
//                                              ))
//                                              .collect(Collectors.toList());
    
//         return ResponseEntity.ok(pedidosDTO);
//     }
    


//     // 2. Ver detalles de un pedido específico por ID
//     @GetMapping("/{id}")
//     public ResponseEntity<PedidosDTO> obtenerDetallesPedido(@PathVariable Long id) {
//         // Buscar el pedido por ID
//         Pedidos detalles = pedidosService.findById(id);
    
//         // Convertir el objeto Pedidos a PedidosDTO
//         PedidosDTO detallesDTO = new PedidosDTO(
//             detalles.getId(), 
//             detalles.getProducto(), 
//             detalles // Pasar el objeto completo si es necesario
//         );
    
//         // Devolver la respuesta
//         return ResponseEntity.ok(detallesDTO);
//     }
    

//     // 3. Actualizar el estado de un pedido
// @PutMapping("/{id}/estado")
// public ResponseEntity<PedidosDTO> actualizarEstadoPedido(
//         @PathVariable Long id,
//         @RequestParam String nuevoEstado) {
//     try {
//         // Llamar al servicio para actualizar el estado del pedido
//         Pedidos pedidoActualizado = pedidosService.actualizarEstadoPedido(id, nuevoEstado);

//         // Convertir el pedido actualizado a un PedidosDTO
//         PedidosDTO pedidoDTO = new PedidosDTO(
//                 pedidoActualizado.getId(),
//                 pedidoActualizado.getProducto(),
//                 pedidoActualizado
//         );

//         // Retornar la respuesta con el DTO
//         return ResponseEntity.ok(pedidoDTO);
//     } catch (RuntimeException e) {
//         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Manejar pedido no encontrado
//     }
// }


//       // 4. Obtener historial de pedidos de un cliente específico (opcional)
//       @GetMapping("/cliente/{clienteId}")
//       public ResponseEntity<List<PedidosDTO>> obtenerHistorialPedidos(@PathVariable Long clienteId) {
//           List<Pedidos> historial = pedidosService.obtenerHistorialPedidos(clienteId);
//           return ResponseEntity.ok(historial);
//       }
    


// }
=======
package com.example.pa.controller;
>>>>>>> main

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
=======
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> main
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pa.controller.DTO.PedidosDTO.PedidosDTO;
import com.example.pa.controller.Mapper.PedidosMapper;
import com.example.pa.model.Pedidos;
<<<<<<< HEAD
=======
import com.example.pa.model.Producto;
>>>>>>> main
import com.example.pa.service.PedidosService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @Autowired
    private PedidosMapper pedidosMapper; // Inyectamos el mapper

<<<<<<< HEAD
=======
    // Crear un nuevo pedido
    @PostMapping
    public ResponseEntity<PedidosDTO> crearPedido(@RequestBody PedidosDTO pedidosDTO) {
        try {
            // Convertir el DTO a la entidad Pedidos
            Pedidos pedido = pedidosMapper.toEntity(pedidosDTO);

            // Crear el pedido usando el servicio
            Pedidos pedidoCreado = pedidosService.crearPedidos(pedido.getId(), pedido.getProducto(), pedido.getCliente());

            // Convertir el pedido creado a un DTO
            PedidosDTO pedidoDTO = pedidosMapper.toDTO(pedidoCreado);

            return ResponseEntity.status(HttpStatus.CREATED).body(pedidoDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

>>>>>>> main
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


<<<<<<< HEAD
    
}

=======
    // Eliminar un producto de la lista de un pedido
    @DeleteMapping("/{id}/productos/{productoId}")
    public ResponseEntity<PedidosDTO> eliminarProductoDePedido(
            @PathVariable Long id,
            @PathVariable Long productoId) {
        try {
            // Llamar al servicio para eliminar el producto
            Pedidos pedidoActualizado = pedidosService.eliminarProducto(id, productoId);

            // Convertir el pedido actualizado a un PedidosDTO
            PedidosDTO pedidoDTO = pedidosMapper.toDTO(pedidoActualizado);

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
              PedidosDTO pedidoDTO = pedidosMapper.toDTO(pedidoRecuperado);
  
              return ResponseEntity.ok(pedidoDTO);
          } catch (RuntimeException e) {
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Manejar pedido no encontrado
          }
      }

    // Agregar un producto
    @PostMapping("/{id}/productos")
        public ResponseEntity<PedidosDTO> agregarProducto(
        @PathVariable Long id,
        @RequestBody Producto producto) {
    Pedidos pedidoActualizado = pedidosService.agregarProducto(id, producto);
    PedidosDTO pedidoDTO = pedidosMapper.toDTO(pedidoActualizado);
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
>>>>>>> main
