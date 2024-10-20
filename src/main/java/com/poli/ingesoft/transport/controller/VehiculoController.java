package com.poli.ingesoft.transport.controller;

import com.poli.ingesoft.transport.domain.Vehiculo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para gestionar las operaciones relacionadas con vehículos.
 *
 * Esta clase expone endpoints para obtener información sobre vehículos
 * y para registrar nuevos vehículos.
 */
@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    /**
     * Obtiene un vehículo por su identificador.
     *
     * @param id El identificador del vehículo que se desea obtener.
     * @return Una respuesta que contiene el vehículo solicitado en caso de éxito,
     *         o un código de error si no se encuentra el vehículo.
     */
    @GetMapping("/obtenerVehiculo")
    public ResponseEntity<Vehiculo> obtenerVehiculo(String id) {
        return null;
    }

    /**
     * Registra un nuevo vehículo.
     *
     * @param vehiculo El objeto {@link Vehiculo} que se desea registrar.
     * @return Una respuesta vacía con el código de estado 201 (Creado) en caso de éxito,
     *         o un código de error si la operación falla.
     */
    @PostMapping("/registrarVehiculo")
    public ResponseEntity<Void> guardarVehiculo(Vehiculo vehiculo) {
        return null;
    }
}
