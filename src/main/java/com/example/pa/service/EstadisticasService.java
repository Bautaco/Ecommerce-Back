package com.example.pa.service;

import com.example.pa.repository.PedidosRepository;
import com.example.pa.repository.ProductoPedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EstadisticasService {

    @Autowired
    private PedidosRepository pedidoRepository;

    @Autowired
    private ProductoPedidoRepository productoPedidoRepository;

    public Double calcularVentasTotales(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return pedidoRepository.calcularVentasTotales(fechaInicio, fechaFin);
    }

    public Long contarPedidos(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return pedidoRepository.contarPedidosEntreFechas(fechaInicio, fechaFin);
    }

    public List<Map<String, Object>> obtenerProductosMasVendidos() {
        List<Object[]> resultados = productoPedidoRepository.obtenerProductosMasVendidos();
        List<Map<String, Object>> productosMasVendidos = new ArrayList<>();

        for (Object[] resultado : resultados) {
            Map<String, Object> producto = new HashMap<>();
            producto.put("nombre", resultado[0]);
            producto.put("cantidadVendida", resultado[1]);
            productosMasVendidos.add(producto);
        }

        return productosMasVendidos;
    }
}
