package com.poli.ingesoft.transport.controller;

import com.poli.ingesoft.transport.domain.Reporte;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para gestionar las operaciones relacionadas con reportes.
 *
 * Esta clase expone endpoints para obtener información sobre reportes
 * y para generar nuevos reportes.
 */
@RestController
@RequestMapping("/reporte")
public class ReporteController {

    /**
     * Obtiene un reporte por su identificador.
     *
     * @param id El identificador del reporte que se desea obtener.
     * @return Una respuesta que contiene el reporte solicitado en caso de éxito,
     *         o un código de error si no se encuentra el reporte.
     */
    @GetMapping("/obtenerReporte")
    public ResponseEntity<Reporte> obtenerReporte(String id) {
        return null;
    }

    /**
     * Genera un nuevo reporte.
     *
     * @param reporte El objeto {@link Reporte} que se desea generar.
     * @return Una respuesta vacía con el código de estado 201 (Creado) en caso de éxito,
     *         o un código de error si la operación falla.
     */
    @PostMapping("/generarReporte")
    public ResponseEntity<Void> generarReporte(Reporte reporte) {
        return null;
    }
}
