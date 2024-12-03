package com.example.pa.controller;

import com.example.pa.model.Promocion;
import com.example.pa.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/promociones")
public class PromocionController {

    @Autowired
    private PromocionService promocionService;

    @PostMapping
    public Promocion crearPromocion(@RequestBody Promocion promocion) {
        return promocionService.crearPromocion(promocion);
    }

    @GetMapping
    public List<Promocion> listarPromocionesActivas() {
        return promocionService.listarPromocionesActivas();
    }

    // Obtener una promoción específica por ID
    @GetMapping("/{id}")
    public Promocion obtenerPromocion(@PathVariable Long id) {
        Optional<Promocion> promocion = promocionService.obtenerPromocionPorId(id);
        if (promocion.isPresent()) {
            return promocion.get();
        } else {
            throw new RuntimeException("Promoción no encontrada con el id " + id);
        }
    }

    // Actualizar una promoción existente por ID
    @PutMapping("/{id}")
    public Promocion actualizarPromocion(@PathVariable Long id, @RequestBody Promocion promocion) {
        Optional<Promocion> promocionExistente = promocionService.obtenerPromocionPorId(id);
        if (promocionExistente.isPresent()) {
            promocion.setId(id);  // Asegúrate de que el ID se mantenga en la actualización
            return promocionService.crearPromocion(promocion); // Usamos el método de crear, ya que hace un save
        } else {
            throw new RuntimeException("Promoción no encontrada con el id " + id);
        }
    }

    // Eliminar una promoción por ID
    @DeleteMapping("/{id}")
    public void eliminarPromocion(@PathVariable Long id) {
        Optional<Promocion> promocionExistente = promocionService.obtenerPromocionPorId(id);
        if (promocionExistente.isPresent()) {
            promocionService.eliminarPromocion(id);
        } else {
            throw new RuntimeException("Promoción no encontrada con el id " + id);
        }
    }
}
