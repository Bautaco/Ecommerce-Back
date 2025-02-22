package com.example.pa.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa.repository.PedidosRepository;
import com.example.pa.repository.ProductoPedidoRepository;

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

    public List<Map<String, Object>> obtenerProductosMasVendidos(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        List<Object[]> resultados = productoPedidoRepository.obtenerProductosMasVendidos(fechaInicio, fechaFin);
        List<Map<String, Object>> productosMasVendidos = new ArrayList<>();

        for (Object[] resultado : resultados) {
            Map<String, Object> producto = new HashMap<>();
            producto.put("nombre", resultado[0]);
            producto.put("cantidadVendida", resultado[1]);
            productosMasVendidos.add(producto);
        }

        return productosMasVendidos;
    }

    public List<Map<String, Object>> obtenerProductoCostosoMasVendidos(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        List<Object[]> resultados = productoPedidoRepository.obtenerProductosMasVendidosxPrecio(fechaInicio, fechaFin);
        List<Map<String, Object>> ProductoCostoso = new ArrayList<>();

        for (Object[] resultado : resultados) {
            Map<String, Object> producto = new HashMap<>();
            producto.put("nombre", resultado[0]);
            producto.put("precioPorUnidad", resultado[1]);
            producto.put("cantidadVendida", resultado[2]);
            producto.put("totalVendido", resultado[3]);
            ProductoCostoso.add(producto);
        }

        return ProductoCostoso;
    }
}
