package com.poli.ingesoft.transport.controller;

import com.poli.ingesoft.transport.domain.Carga;
import com.poli.ingesoft.transport.service.CargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con cargas.
 *
 * Esta clase expone endpoints para obtener y guardar información sobre cargas.
 */
@RestController
@RequestMapping("/carga")
public class CargaController {

    private final CargaService cargaService;

    @Autowired
    public CargaController(CargaService cargaService) {
        this.cargaService = cargaService;
    }

    /**
     * Obtiene todas las cargas.
     *
     * @return Una respuesta que contiene la carga solicitada en caso de éxito.
     *
     */
    @GetMapping("/obtenerCargas")
    public ResponseEntity<List<Carga>> obtenerCargad() {
        List<Carga> response = cargaService.obtenerCargas();
        return ResponseEntity.ok(response);
    }

    /**
     * Actualiza el estado de una carga específica.
     *
     * @param idCarga El identificador único de la carga cuyo estado se desea actualizar.
     * @return Una respuesta con el código de estado 200 (OK) y el valor entero devuelto por el servicio,
     *         que indica el resultado de la operación.
     *         Puede retornar un código de error si ocurre alguna falla durante el proceso.
     */
    @PostMapping("/actualizarEstado/{idCarga}")
    public ResponseEntity<Integer> actualizarEstadoCarga(@PathVariable String idCarga) {
        Integer response = cargaService.actualizarEstado(idCarga);
        return ResponseEntity.ok(response);
    }

    /**
     * Guarda una nueva carga.
     *
     * @param carga El objeto {@link Carga} que se desea guardar.
     * @return Una respuesta vacía con el código de estado 201 (Creado) en caso de éxito,
     *         o un código de error si la operación falla.
     */
    @PostMapping("/guardarCarga")
    public ResponseEntity<String> guardarCarga(@RequestBody Carga carga) {
        String response = cargaService.guardarCarga(carga);
        return ResponseEntity.ok(response);
    }
}
