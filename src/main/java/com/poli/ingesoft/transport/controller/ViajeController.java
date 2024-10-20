package com.poli.ingesoft.transport.controller;

import com.poli.ingesoft.transport.domain.Viaje;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para gestionar las operaciones relacionadas con viajes.
 *
 * Esta clase expone endpoints para obtener información sobre viajes
 * y para guardar nuevos viajes.
 */
@RestController
@RequestMapping("/viaje")
public class ViajeController {

    /**
     * Obtiene un viaje por su identificador.
     *
     * @param id El identificador del viaje que se desea obtener.
     * @return Una respuesta que contiene el viaje solicitado en caso de éxito,
     *         o un código de error si no se encuentra el viaje.
     */
    @GetMapping("/obtenerViaje")
    public ResponseEntity<Viaje> obtenerViaje(String id) {
        return null;
    }

    /**
     * Guarda un nuevo viaje.
     *
     * @param viaje El objeto {@link Viaje} que se desea guardar.
     * @return Una respuesta vacía con el código de estado 201 (Creado) en caso de éxito,
     *         o un código de error si la operación falla.
     */
    @PostMapping("/guardarViaje")
    public ResponseEntity<Void> guardarViaje(Viaje viaje) {
        return null;
    }
}
