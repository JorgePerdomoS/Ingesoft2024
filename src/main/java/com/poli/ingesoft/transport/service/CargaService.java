package com.poli.ingesoft.transport.service;

import com.poli.ingesoft.transport.domain.Carga;
import org.springframework.stereotype.Service;

/**
 * Interface que define los servicios relacionados con la gestión de cargas en el sistema de transporte.
 * Proporciona métodos para actualizar el estado de una carga, verificar si ha llegado al punto de entrega,
 * obtener los detalles de una carga específica y guardar la información de una carga.
 */
@Service
public interface CargaService {

    /**
     * Actualiza el estado de una carga.
     *
     * @param estado el nuevo estado de la carga (puede ser "En tránsito", "Entregado", etc.).
     */
    void actualizarEstado(String estado);

    /**
     * Verifica si la carga ha llegado al punto de entrega.
     * Este método debería incluir la lógica necesaria para determinar si la carga
     * ha alcanzado su destino final.
     */
    void verificarEnPuntoEntrega();

    /**
     * Obtiene una carga específica en función de su identificador.
     *
     * @param id el identificador único de la carga.
     * @return la instancia de {@link Carga} que coincide con el ID proporcionado.
     */
    Carga obtenerCarga(String id);

    /**
     * Guarda o persiste una instancia de carga en el sistema.
     *
     * @param carga la instancia de {@link Carga} que se debe guardar.
     */
    void guardarCarga(Carga carga);
}
