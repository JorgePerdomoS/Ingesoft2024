package com.poli.ingesoft.transport.controller;

import com.poli.ingesoft.transport.domain.Viaje;
import com.poli.ingesoft.transport.service.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para gestionar las operaciones relacionadas con viajes.
 *
 * Esta clase expone endpoints para obtener información sobre viajes
 * y para guardar nuevos viajes.
 */
@RestController
@RequestMapping("/viaje")
public class ViajeController {

    private final ViajeService viajeService;

    @Autowired
    public ViajeController(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    /**
     * Obtiene un viaje por su identificador.
     *
     * @param id El identificador del viaje que se desea obtener.
     * @return Una respuesta que contiene el viaje solicitado en caso de éxito,
     *         o un código de error si no se encuentra el viaje.
     */
    @GetMapping("/obtenerViaje/{id}")
    public ResponseEntity<Viaje> obtenerViaje(@PathVariable String id) {
        Viaje result = viajeService.obtenerViaje(id);
        return ResponseEntity.ok(result);
    }

    /**
     * Guarda un nuevo viaje.
     *
     * @param viaje El objeto {@link Viaje} que se desea guardar.
     * @return Una respuesta vacía con el código de estado 201 (Creado) en caso de éxito,
     *         o un código de error si la operación falla.
     */
    @PostMapping("/guardarViaje")
    public ResponseEntity<String> guardarViaje(@RequestBody Viaje viaje) {
        String result = viajeService.guardarViaje(viaje);
        return ResponseEntity.ok(result);
    }
}
