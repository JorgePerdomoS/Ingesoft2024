package com.poli.ingesoft.transport.controller;

import com.poli.ingesoft.transport.domain.Reporte;
import com.poli.ingesoft.transport.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para gestionar las operaciones relacionadas con reportes.
 *
 * Esta clase expone endpoints para obtener información sobre reportes
 * y para generar nuevos reportes.
 */
@RestController
@RequestMapping("/reporte")
public class ReporteController {

    private final ReporteService reporteService;

    @Autowired
    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    /**
     * Obtiene un reporte por su identificador.
     *
     * @param id El identificador del reporte que se desea obtener.
     * @return Una respuesta que contiene el reporte solicitado en caso de éxito,
     *         o un código de error si no se encuentra el reporte.
     */
    @GetMapping("/obtenerReporte/{id}")
    public ResponseEntity<Reporte> obtenerReporte(@PathVariable String id) {
        Reporte resp = reporteService.obtenerReporte(id);
        if (resp != null) {
            return ResponseEntity.ok(resp);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Genera un nuevo reporte.
     *
     * @param reporte El objeto {@link Reporte} que se desea generar.
     * @return Una respuesta vacía con el código de estado 201 (Creado) en caso de éxito,
     *         o un código de error si la operación falla.
     */
    @PostMapping("/generarReporte")
    public ResponseEntity<String> generarReporte(@RequestBody Reporte reporte) {
       String response = reporteService.guardarReporte(reporte);
       return ResponseEntity.ok(response);
    }
}
