package com.example.pa.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa.model.Variante;
import com.example.pa.repository.VarianteRepository;

@Service
public class VarianteService {

    @Autowired
    private VarianteRepository varianteRepository;

    // Método para listar solo variantes activas
    public List<Variante> listarVariantesActivas() {
        return varianteRepository.findByActivoTrue();
    }

    // Método para crear una nueva variante
    public Variante crearVariante(Variante variante) {
        return varianteRepository.save(variante);
    }

    // Método para actualizar una variante existente
    public Variante actualizarVariante(Long id, Variante varianteActualizada) {
        Optional<Variante> optionalVariante = varianteRepository.findById(id);
        if (optionalVariante.isPresent()) {
            Variante variante = optionalVariante.get();
            variante.setColor(varianteActualizada.getColor());
            variante.setTalle(varianteActualizada.getTalle());
            variante.setMaterial(varianteActualizada.getMaterial());
            variante.setEstilo(varianteActualizada.getEstilo());
            variante.setActivo(varianteActualizada.isActivo());

             
        // Actualiza el stock solo si el valor en varianteActualizada es distinto de cero
        int nuevoStock = varianteActualizada.getStock();
        if (nuevoStock >= 0) { // Asegura que el stock no sea negativo
            variante.setStock(nuevoStock);
        } else {
            throw new RuntimeException("El stock no puede ser negativo");
        }
        
        return varianteRepository.save(variante);
    } else {
        throw new RuntimeException("Variante no encontrada");
        }
    }

    // Método para "eliminar" una variante (cambio de estado a inactivo)
    public void eliminarVariante(Long id) {
        Optional<Variante> optionalVariante = varianteRepository.findById(id);
        if (optionalVariante.isPresent()) {
            Variante variante = optionalVariante.get();
            variante.setActivo(false);  // Cambia el estado a inactivo
            varianteRepository.save(variante);
        } else {
            throw new RuntimeException("Variante no encontrada");
        }
    }

    // Método para "recuperar" una variante eliminada
    public Variante recuperarVariante(Long id) {
        Optional<Variante> optionalVariante = varianteRepository.findById(id);
        if (optionalVariante.isPresent()) {
            Variante variante = optionalVariante.get();
            variante.setActivo(true);  // Cambia el estado a activo
            return varianteRepository.save(variante);
        } else {
            throw new RuntimeException("Variante no encontrada");
        }
    }

    public void save(VarianteService varianteService) {
        
        throw new UnsupportedOperationException("Método no implementado 'guardar'");
    }

    public Variante findById(Long id) {
        
        throw new UnsupportedOperationException("Método no implementado 'findById'");
    }

    public void actualizarVariante(Long id, int cantidad) {
        throw new UnsupportedOperationException("Método no implementado 'actualizarVariante'");
    }
}
