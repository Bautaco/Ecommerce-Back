package com.example.pa.service;

import com.example.pa.controller.DTO.EstadisticaDTO.EstadisticaClienteDTO;
import com.example.pa.model.EstadisticaCliente;
import com.example.pa.repository.EstadisticaClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadisticaClienteService {

    @Autowired
    private EstadisticaClienteRepository EstadisticaClienteRepository;

    public EstadisticaClienteDTO obtenerEstadisticasCliente(Long clienteId) {
        List<EstadisticaCliente> estadisticas = EstadisticaClienteRepository.findByClienteId(clienteId);

        // Cálculos para la frecuencia de compra, valor promedio del pedido, productos favoritos
        int frecuenciaCompra = estadisticas.size();
        double valorPromedioPedido = estadisticas.stream().mapToDouble(EstadisticaCliente::getValorPromedioPedido).average().orElse(0.0);
        String productosFavoritos = "TODO: Productos favoritos"; // Implementar lógica para encontrar productos más comprados

        return new EstadisticaClienteDTO(clienteId, frecuenciaCompra, valorPromedioPedido, productosFavoritos);
    }
}

