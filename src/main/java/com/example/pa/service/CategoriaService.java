package com.example.pa.service;

import com.example.pa.controller.DTO.CategoriaDTO.CategoriaDTO;
import com.example.pa.controller.Mapper.CategoriaMapper;
import com.example.pa.model.Categoria;
import com.example.pa.repository.CategoriaRepository; // Importa el repositorio 'CategoriaRepository', que maneja la interacción con la base de datos

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación '@Autowired' para la inyección de dependencias.
import org.springframework.stereotype.Service; // Importa la anotación '@Service', que indica que esta clase es un servicio de la aplicación.

import java.util.List;
import java.util.Optional;

@Service // Anota esta clase como un servicio, indicando que contiene la lógica de negocio. Spring la gestionará como un bean.
public class CategoriaService {

    @Autowired // Inyecta automáticamente el repositorio 'CategoriaRepository' en esta clase para poder usar sus métodos de acceso a la base de datos.
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;
    

    // Creacion de Nueva Categoria
     public CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        categoria = categoriaRepository.save(categoria);
        return categoriaMapper.toDTO(categoria);
    }

    // Actilizacion de Categorias
    public CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);
        if (categoriaOpt.isPresent()) {
            Categoria categoria = categoriaOpt.get();
            categoria.setNombre(categoriaDTO.getNombre());
            categoriaRepository.save(categoria);
            return categoriaMapper.toDTO(categoria);
        }
        return null;
    }

    // Eliminacion de una Categoría (Cambio de estado "Inactiva")
    public void eliminarCategoria(Long id) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);
        if (categoriaOpt.isPresent()) {
            Categoria categoria = categoriaOpt.get();
                // Cambiar el estado de la categoría a "Inactiva"
                categoria.setActivo(false);  // Suponiendo que "activo" es el atributo que indica si está activa o no
                
                // Guardar los cambios
                categoriaRepository.save(categoria);
            } else {
                // Lógica en caso de que no se encuentre la categoría, si es necesario
                throw new EntityNotFoundException("Categoría no encontrada");
            }
        }
        
    // Recuperacion de Categoria (Cambio de estado "Activa")
    // Recuperación de una Categoría (Cambio de estado a "Activa")
    public void recuperarCategoria(Long id) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);
        if (categoriaOpt.isPresent()) {
            Categoria categoria = categoriaOpt.get();

            // Verifica si la categoría ya está activa
            if (!categoria.isActivo()) {
                // Cambiar el estado de la categoría a "Activa"
                categoria.setActivo(true);

                // Guardar los cambios
                categoriaRepository.save(categoria);
            } else {
                throw new IllegalStateException("La categoría ya está activa.");
            }
        } else {
            // Lógica en caso de que no se encuentre la categoría
            throw new EntityNotFoundException("Categoría no encontrada");
        }
    }


    public List<CategoriaDTO> obtenerCategorias() {
        List<Categoria> categorias = categoriaRepository.findByActivoTrue();
        return categorias.stream().map(categoriaMapper::toDTO).toList();
    }

}

