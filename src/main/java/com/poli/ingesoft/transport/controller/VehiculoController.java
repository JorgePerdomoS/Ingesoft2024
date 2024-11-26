package com.poli.ingesoft.transport.controller;

import com.poli.ingesoft.transport.domain.Vehiculo;
import com.poli.ingesoft.transport.service.VehiculoService;
import com.poli.ingesoft.transport.util.enums.GlobalState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * Controlador para gestionar las operaciones relacionadas con vehículos.
 * Esta clase expone endpoints para obtener información sobre vehículos
 * y para registrar nuevos vehículos.
 */
@RestController
@RequestMapping("/vehiculo")
@Slf4j
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @Autowired
    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    /**
     * Obtiene un vehículo por su identificador.
     *
     * @param placa El identificador del vehículo que se desea obtener.
     * @return Una respuesta que contiene el vehículo solicitado en caso de éxito,
     *         o un código de error si no se encuentra el vehículo.
     */
    @GetMapping("/obtenerVehiculo/{placa}")
    public ResponseEntity<Vehiculo> obtenerVehiculo(@PathVariable String placa) {
        Vehiculo response = vehiculoService.obtenerVehiculo(placa);
        if (response == null) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(204));
        }
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }

    /**
     * Registra un nuevo vehículo.
     *
     * @param vehiculo El objeto {@link Vehiculo} que se desea registrar.
     * @return Una respuesta vacía con el código de estado 201 (Creado) en caso de éxito,
     *         o un código de error si la operación falla.
     */
    @PostMapping("/registrarVehiculo")
    public ResponseEntity<Integer> guardarVehiculo(@RequestBody Vehiculo vehiculo) {
        Integer response = vehiculoService.guardarVehiculo(vehiculo);
        if (Objects.equals(response, GlobalState.ALREADY_EXIST.getValue())) {
            return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }

    /**
     * Obtiene la lista de vehículos registrados.
     *
     * Este método proporciona una lista completa de los vehículos almacenados en el sistema.
     * Los datos se recuperan a través del servicio {@link VehiculoService}.
     *
     * @return Una respuesta con una lista de objetos {@link Vehiculo} y el código de estado HTTP 200 (OK)
     *         si la operación se realiza con éxito. Si ocurre un error inesperado, se devolverá un código HTTP 500 (Error Interno del Servidor).
     */
    @GetMapping("/obtenerVehiculos")
    public ResponseEntity<List<Vehiculo>> listarVehiculos() {
        List<Vehiculo> response = vehiculoService.obtenerVehiculos();
            return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));

    }
}
