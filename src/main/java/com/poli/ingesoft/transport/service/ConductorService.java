package com.poli.ingesoft.transport.service;

import com.poli.ingesoft.transport.domain.Conductor;
import org.springframework.stereotype.Service;

/**
 * Interface que define los servicios relacionados con la gestión de conductores en el sistema de transporte.
 * Proporciona métodos para obtener información de un conductor, guardar datos de un conductor,
 * reportar entregas realizadas y consultar rutas asignadas.
 */
@Service
public interface ConductorService {

    /**
     * Obtiene los detalles de un conductor en función de su identificador.
     *
     * @param idConductor el identificador único del conductor.
     * @return la instancia de {@link Conductor} que coincide con el ID proporcionado.
     */
    Conductor obtenerConductor(String idConductor);

    /**
     * Guarda o persiste una instancia de conductor en el sistema.
     *
     * @param conductor la instancia de {@link Conductor} que se debe guardar.
     */
    void guardarConductor(Conductor conductor);

    /**
     * Reporta la entrega realizada por el conductor.
     * Este método debería incluir la lógica necesaria para actualizar el estado
     * de la entrega o generar un reporte de la misma.
     */
    void reportarEntrega();

    /**
     * Consulta la ruta asignada al conductor.
     * Este método debería obtener y mostrar la información relacionada con la
     * ruta que debe seguir el conductor para realizar sus entregas.
     */
    void consultarRuta();
}
