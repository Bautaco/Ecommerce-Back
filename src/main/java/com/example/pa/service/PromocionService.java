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

    /**
     * Calcular el descuento aplicado al carrito.
     */
    public double calcularDescuentoCarrito(List<Producto> productos) {
        LocalDate hoy = LocalDate.now();
        List<Promocion> promocionesActivas = listarPromocionesActivas();

        if (promocionesActivas.isEmpty()) return calcularTotalCarrito(productos);

        Promocion promocion = promocionesActivas.get(0); // Consideramos la primera promoción válida
        double total = calcularTotalCarrito(productos);

        return total - (total * (promocion.getPorcentajeDescuento() / 100));
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
        return productos.stream().mapToDouble(p -> p.getPrecio() * p.getStock()).sum();
    }
    
}
