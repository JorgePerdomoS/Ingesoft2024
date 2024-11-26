package com.poli.ingesoft.transport.service;

import com.poli.ingesoft.transport.domain.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface que define los servicios relacionados con la gestión de vehículos
 * en el sistema de transporte. Proporciona métodos para actualizar la ubicación
 * del vehículo, reportar su estado, obtener detalles de un vehículo específico y
 * guardar información de vehículos.
 */
@Service
public interface VehiculoService {

    /**
     * Actualiza la ubicación actual del vehículo.
     * Este método debería incluir la lógica necesaria para obtener la nueva ubicación
     * (por ejemplo, mediante GPS) y actualizar la información correspondiente en el sistema.
     */
    void actualizarUbicacion();

    /**
     * Reporta el estado del vehículo.
     * Este método permite que el sistema registre el estado actual del vehículo,
     * que puede incluir datos sobre mantenimiento, disponibilidad, o cualquier otro
     * estado relevante.
     */
    void reportarEstado();

    /**
     * Obtiene los detalles de un vehículo específico en función de su identificador.
     *
     * @param placa el identificador único del vehículo.
     * @return la instancia de {@link Vehiculo} que coincide con el ID proporcionado.
     */
    Vehiculo obtenerVehiculo(String placa);

    /**
     * Guarda o actualiza la información de un vehículo en el sistema.
     *
     * @param vehiculo la instancia de {@link Vehiculo} que se debe guardar o actualizar.
     */
    Integer guardarVehiculo(Vehiculo vehiculo);

    /**
     * Obtiene la lista completa de vehículos almacenados en el sistema.
     * Este método se utiliza para recuperar todos los vehículos registrados en el sistema. Los datos
     * obtenidos pueden incluir información como marca, modelo, año, estado, y más.
     *
     * @return Una lista de objetos {@link Vehiculo} que representa todos los vehículos registrados.
     *         Si no hay vehículos registrados, se devuelve una lista vacía.
     */
    List<Vehiculo> obtenerVehiculos();
}
