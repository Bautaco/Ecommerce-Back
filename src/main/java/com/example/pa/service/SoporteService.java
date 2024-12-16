package com.example.pa.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.pa.controller.DTO.ConsultaDTO.ConsultaDTO;
import com.example.pa.model.Consulta;
import com.example.pa.model.EstadoConsulta;
import com.example.pa.repository.ConsultaRepository;

@Service
public class SoporteService {

    private static final String RUTA_ARCHIVOS = System.getProperty("user.dir") + File.separator + "archivosSoporte" + File.separator;

    private static final Map<EstadoConsulta, List<EstadoConsulta>> TRANSICIONES_PERMITIDAS = Map.of(
        EstadoConsulta.PENDIENTE, List.of(EstadoConsulta.EN_PROCESO, EstadoConsulta.RESUELTA),
        EstadoConsulta.EN_PROCESO, List.of(EstadoConsulta.RESUELTA),
        EstadoConsulta.RESUELTA, List.of()
    );

    @Autowired
    private ConsultaRepository consultaRepository;

    public SoporteService() {
        verificarPermisosDeEscritura();
    }

    private void verificarPermisosDeEscritura() {
        File directorio = new File(RUTA_ARCHIVOS);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
        if (!directorio.canWrite()) {
            throw new RuntimeException("No hay permisos de escritura en el directorio: " + RUTA_ARCHIVOS);
        }
    }

    public Consulta crearConsulta(ConsultaDTO consultaDTO) throws IOException {
        if (consultaDTO == null || consultaDTO.getDescripcion() == null || consultaDTO.getArchivos() == null) {
            throw new IllegalArgumentException("ConsultaDTO o sus campos obligatorios no pueden ser nulos.");
        }

        Consulta consulta = new Consulta(null, RUTA_ARCHIVOS, null, null, null);
        consulta.setDescripcion(consultaDTO.getDescripcion());
        consulta.setFechaEnvio(LocalDateTime.now());

        // Guardar archivos y obtener las rutas
        List<String> rutasArchivos = guardarArchivos(consultaDTO.getArchivos());
        consulta.setArchivosAdjuntos(rutasArchivos);

        return consultaRepository.save(consulta);
    }

    private List<String> guardarArchivos(List<MultipartFile> archivos) throws IOException {
        List<String> rutasGuardadas = new ArrayList<>();

        for (MultipartFile archivo : archivos) {
            if (!archivo.isEmpty()) {
                validarTipoArchivo(archivo.getContentType());

                String nombreArchivo = UUID.randomUUID() + "_" + archivo.getOriginalFilename();
                File archivoDestino = new File(RUTA_ARCHIVOS + nombreArchivo);
                archivo.transferTo(archivoDestino);
                rutasGuardadas.add(nombreArchivo);
            }
        }

        return rutasGuardadas;
    }

    private void validarTipoArchivo(String tipoArchivo) {
        if (!TipoArchivoPermitido.esPermitido(tipoArchivo)) {
            throw new IllegalArgumentException("Tipo de archivo no permitido. Solo se aceptan imágenes (PNG, JPEG). Tipo: " + tipoArchivo);
        }
    }

    public Consulta cambiarEstadoConsulta(Long consultaId, EstadoConsulta nuevoEstado) {
        Consulta consulta = consultaRepository.findById(consultaId)
                .orElseThrow(() -> new IllegalArgumentException("Consulta no encontrada con id: " + consultaId));

        List<EstadoConsulta> permitidos = TRANSICIONES_PERMITIDAS.get(consulta.getEstado());
        if (!permitidos.contains(nuevoEstado)) {
            throw new IllegalStateException("Transición de estado no permitida: " + consulta.getEstado() + " a " + nuevoEstado);
        }

        consulta.setEstado(nuevoEstado);
        return consultaRepository.save(consulta);
    }

    public List<Consulta> obtenerTodasLasConsultas() {
        return consultaRepository.findAll();
    }

    private enum TipoArchivoPermitido {
        PNG("image/png"),
        JPEG("image/jpeg"),
        JPG("image/jpg");

        private final String mimeType;

        TipoArchivoPermitido(String mimeType) {
            this.mimeType = mimeType;
        }

        public static boolean esPermitido(String mimeType) {
            for (TipoArchivoPermitido tipo : values()) {
                if (tipo.mimeType.equals(mimeType)) {
                    return true;
                }
            }
            return false;
        }
    }
}
