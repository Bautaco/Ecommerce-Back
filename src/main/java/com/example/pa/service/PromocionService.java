package com.example.pa.service;

import com.example.pa.model.Producto;
import com.example.pa.model.Promocion;
import com.example.pa.repository.PromocionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PromocionService {

    @Autowired
    private PromocionRepository promocionRepository;

    /**
     * Crear una nueva promoción.
     */
    public Promocion crearPromocion(Promocion promocion) {
        return promocionRepository.save(promocion);
    }

    /**
     * Listar todas las promociones activas.
     */
    public List<Promocion> listarPromocionesActivas() {
        LocalDate hoy = LocalDate.now();
        return promocionRepository.findByActivaTrueAndFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(hoy, hoy);
    }

    public double calcularDescuentoCarrito(List<Producto> productos) {
        double total = calcularTotalCarrito(productos);
        return promocionRepository.findByActivaTrueAndFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(LocalDate.now(), null)
            .stream()
            .findFirst()
            .map(promocion -> total - (total * (promocion.getPorcentajeDescuento() / 100)))
            .orElse(total);
    }
    

        // Obtener una promoción por ID.
        public Optional<Promocion> obtenerPromocionPorId(Long id) {
            return promocionRepository.findById(id);
        }
    
        // Eliminar una promoción por ID.
        public void eliminarPromocion(Long id) {
            promocionRepository.deleteById(id);
        }

    /**
     * Calcular el total del carrito sin aplicar descuentos.
     */
    private double calcularTotalCarrito(List<Producto> productos) {
        return productos.stream()
            .mapToDouble(p -> {
                if (p.getStock() != null) { 
                    return p.getPrecio() * p.getStock().getCantidad();
                }
                return 0; // Si no hay stock asociado, el valor es 0 para ese producto
            })
            .sum();
    }


    public List<Promocion> obtenerPromociones() {
        return promocionRepository.findAll();  // Devolverá una lista vacía si no hay promociones
    }

    public List<Promocion> obtenerPromociones() {
        return promocionRepository.findAll();  // Devolverá una lista vacía si no hay promociones
    }
    
}
