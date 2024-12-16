package com.example.pa.controller.DTO.ConsultaDTO;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import com.example.pa.model.EstadoConsulta;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ConsultaDTO {

    private String descripcion;
    private EstadoConsulta estado; // Este campo permitirá mapear el estado como String.
    private List<MultipartFile> archivos;

    // Getters y setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoConsulta getEstado() {
        return estado;
    }

    public void setEstado(EstadoConsulta estado) {
        this.estado = estado;
    }

    public List<MultipartFile> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<MultipartFile> archivos) {
        this.archivos = archivos;
    }
}
