package com.example.pa.service;

import com.example.pa.controller.DTO.MarcaDTO.MarcaDTO;
import com.example.pa.controller.Mapper.MarcaMapper;
import com.example.pa.model.Marca;
import com.example.pa.repository.MarcaRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private MarcaMapper marcaMapper;

   public MarcaDTO crearMarca(MarcaDTO marcaDTO) {
        Marca marca = marcaMapper.toEntity(marcaDTO);
        marca = marcaRepository.save(marca);
        return marcaMapper.toDTO(marca);
    }

    public MarcaDTO actualizarMarca(Long id, MarcaDTO marcaDTO) {
        Optional<Marca> marcaOpt = marcaRepository.findById(id);
        if (marcaOpt.isPresent()) {
            Marca marca = marcaOpt.get();
            marca.setNombre(marcaDTO.getNombre());
            marcaRepository.save(marca);
            return marcaMapper.toDTO(marca);
        }
        return null;
    }
   
    public void eliminarMarca(Long id) {
        Optional<Marca> marcaOpt = marcaRepository.findById(id);
        if (marcaOpt.isPresent()) {
            Marca marca = marcaOpt.get();
            marca.setActivo(false);  // Eliminación lógica
            marcaRepository.save(marca);
        }
    }
   
        public void recuperarMarca(Long id) {
        Optional<Marca> marcaOpt = marcaRepository.findById(id);
        if (marcaOpt.isPresent()) {
            Marca marca = marcaOpt.get();
            
            // Cambiar el estado de la marca a "Activa"
            if (!marca.isActivo()) {  // Solo si está inactiva
                marca.setActivo(true); 
                marcaRepository.save(marca);  // Guardar los cambios
            } else {
                throw new IllegalStateException("La marca ya está activa.");
            }
        } else {
            throw new EntityNotFoundException("Marca no encontrada.");
        }
    }


    public List<MarcaDTO> obtenerMarcas() {
        List<Marca> marcas = marcaRepository.findByActivoTrue();
        return marcas.stream()
                     .map(marcaMapper::toDTO)
                     .toList();
    }
}