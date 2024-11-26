package com.poli.ingesoft.transport.service;

import com.poli.ingesoft.transport.domain.Carga;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * @param idCarga el id generado al guardarse en base de datos
     */
    Integer actualizarEstado(String idCarga);


    /**
     * Obtiene una carga específica en función de su identificador.
     *
     * @return la instancia de {@link Carga} que coincide con el ID proporcionado.
     */
    List<Carga> obtenerCargas();

    /**
     * Guarda o persiste una instancia de carga en el sistema.
     *
     * @param carga la instancia de {@link Carga} que se debe guardar.
     *
     * @return retorna un estado siendo 1 OK
     */
    String guardarCarga(Carga carga);
}
