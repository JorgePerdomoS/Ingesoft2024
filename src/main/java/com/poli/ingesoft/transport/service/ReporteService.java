package com.poli.ingesoft.transport.service;

import com.poli.ingesoft.transport.domain.Reporte;
import org.springframework.stereotype.Service;

/**
 * Interface que define los servicios relacionados con la generación y gestión de reportes
 * en el sistema de transporte. Proporciona métodos para generar, obtener y guardar reportes.
 */
@Service
public interface ReporteService {

    /**
     * Genera un nuevo reporte en el sistema.
     * Este método debería incluir la lógica necesaria para recopilar los datos pertinentes
     * y crear un informe, que puede ser sobre el desempeño, entregas, o cualquier otra
     * actividad relacionada con el sistema de transporte.
     */
    void generarReporte();

    /**
     * Obtiene los detalles de un reporte específico en función de su identificador.
     *
     * @param reporteId el identificador único del reporte.
     * @return la instancia de {@link Reporte} que coincide con el ID proporcionado.
     */
    Reporte obtenerReporte(String reporteId);

    /**
     * Guarda o actualiza un reporte en el sistema.
     *
     * @param reporte la instancia de {@link Reporte} que se debe guardar o actualizar.
     */
    void guardarReporte(Reporte reporte);
}
