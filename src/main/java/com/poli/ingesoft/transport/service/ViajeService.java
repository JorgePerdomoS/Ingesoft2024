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
     * Inicia un viaje en el sistema.
     * Este método debería incluir la lógica necesaria para registrar el inicio del viaje,
     * como la hora de salida, el vehículo y el conductor asignado.
     */
    void iniciarViaje();

    /**
     * Finaliza un viaje en el sistema.
     * Este método registra la conclusión del viaje, incluyendo la hora de llegada
     * y cualquier información adicional relevante para cerrar el viaje.
     */
    void finalizarViaje();

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
    void guardarViaje(Viaje viaje);
}
