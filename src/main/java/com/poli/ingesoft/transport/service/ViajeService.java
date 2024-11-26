package com.poli.ingesoft.transport.service;

import com.poli.ingesoft.transport.domain.Viaje;
import org.springframework.stereotype.Service;

/**
 * Interface que define los servicios relacionados con la gestión de viajes
 * en el sistema de transporte. Proporciona métodos para iniciar y finalizar un viaje,
 * obtener detalles de un viaje específico, y guardar la información de viajes.
 */
@Service
public interface ViajeService {

    /**
     * Obtiene los detalles de un viaje específico en función de su identificador.
     *
     * @param viajeId el identificador único del viaje.
     * @return la instancia de {@link Viaje} que coincide con el ID proporcionado.
     */
    Viaje obtenerViaje(String viajeId);

    /**
     * Guarda o actualiza la información de un viaje en el sistema.
     *
     * @param viaje la instancia de {@link Viaje} que se debe guardar o actualizar.
     */
    String guardarViaje(Viaje viaje);
}
