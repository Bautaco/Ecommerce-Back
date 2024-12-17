package com.example.pa.controller;


import com.example.pa.model.Promocion;
import com.example.pa.service.PromocionService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/promociones")
public class PromocionController {

    @Autowired
    private PromocionService promocionService;

    // Crear una nueva promoción
    @PostMapping 
    public Promocion crearPromocion(@Valid @RequestBody Promocion promocion) {
        return promocionService.crearPromocion(promocion);
    }


    // Listar todas las promociones activas
    @GetMapping
    public List<Promocion> listarPromocionesActivas() {
        return promocionService.listarPromocionesActivas();
    }

    // Obtener una promoción específica por ID
    @GetMapping("/{id}")
    public ResponseEntity<List<Promocion>> obtenerPromociones() {
        List<Promocion> promociones = promocionService.obtenerPromociones();

        // Si la lista está vacía, devolvemos una respuesta con código 200 y lista vacía
        if (promociones.isEmpty()) {
            return ResponseEntity.ok().body(Collections.emptyList());
        }

        // Si hay promociones, las devolvemos normalmente
        return ResponseEntity.ok(promociones);
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
