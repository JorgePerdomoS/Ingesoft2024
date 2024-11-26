package com.poli.ingesoft.transport.service;

import com.poli.ingesoft.transport.domain.Emergencia;
import org.springframework.stereotype.Service;

/**
 * Interface que define los servicios relacionados con la gestión de emergencias
 * en el sistema de transporte. Proporciona métodos para reportar, obtener y
 * guardar emergencias.
 */
@Service
public interface EmergenciaService {

    /**
     * Obtiene los detalles de una emergencia específica en función de su identificador.
     *
     * @param emergenciaId el identificador único de la emergencia.
     * @return la instancia de {@link Emergencia} que coincide con el ID proporcionado.
     */
    Emergencia obtenerEmergencia(String emergenciaId);

    /**
     * Guarda o actualiza una emergencia en el sistema.
     *
     * @param emergencia la instancia de {@link Emergencia} que se debe guardar o actualizar.
     */
    String guardarEmergencia(Emergencia emergencia);
}
