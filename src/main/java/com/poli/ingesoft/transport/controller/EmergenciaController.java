package com.poli.ingesoft.transport.controller;

import com.poli.ingesoft.transport.domain.Emergencia;
import com.poli.ingesoft.transport.service.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para gestionar las operaciones relacionadas con emergencias.
 *
 * Esta clase expone endpoints para obtener información sobre emergencias
 * y para reportar nuevas emergencias.
 */
@RestController
@RequestMapping("/emergencia")
public class EmergenciaController {

    private final EmergenciaService emergenciaService;

    @Autowired
    public EmergenciaController(EmergenciaService emergenciaService){
        this.emergenciaService = emergenciaService;
    }

    /**
     * Obtiene la emergencia por su identificador.
     *
     * @param id El identificador de la emergencia que se desea obtener.
     * @return Una respuesta que contiene la emergencia solicitada en caso de éxito,
     *         o un código de error si no se encuentra la emergencia.
     */
    @GetMapping("/obtenerEmergencia")
    public ResponseEntity<Emergencia> obtenerEmergencia(String id) {
        return null;
    }

    /**
     * Reporta una nueva emergencia.
     *
     * @param emergencia El objeto {@link Emergencia} que se desea reportar.
     * @return Una respuesta vacía con el código de estado 201 (Creado) en caso de éxito,
     *         o un código de error si la operación falla.
     */
    @PostMapping("/reportarEmergencia")
    public ResponseEntity<Integer> reportarEmergencia(Emergencia emergencia) {
        return null;
    }
}
