package com.poli.ingesoft.transport.controller;

import com.poli.ingesoft.transport.domain.Carga;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para gestionar las operaciones relacionadas con cargas.
 *
 * Esta clase expone endpoints para obtener y guardar información sobre cargas.
 */
@RestController
@RequestMapping("/carga")
public class CargaController {

    /**
     * Obtiene una carga por su identificador.
     *
     * @param id El identificador de la carga que se desea obtener.
     * @return Una respuesta que contiene la carga solicitada en caso de éxito,
     *         o un código de error si no se encuentra la carga.
     */
    @GetMapping("/obtenerCarga")
    public ResponseEntity<Carga> obtenerCarga(String id) {
        return null; // Implementar lógica para obtener la carga
    }

    /**
     * Guarda una nueva carga.
     *
     * @param carga El objeto {@link Carga} que se desea guardar.
     * @return Una respuesta vacía con el código de estado 201 (Creado) en caso de éxito,
     *         o un código de error si la operación falla.
     */
    @PostMapping("/guardarCarga")
    public ResponseEntity<Void> guardarCarga(Carga carga) {
        return null; // Implementar lógica para guardar la carga
    }
}
