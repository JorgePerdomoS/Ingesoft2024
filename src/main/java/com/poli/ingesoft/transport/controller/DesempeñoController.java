package com.poli.ingesoft.transport.controller;

import com.poli.ingesoft.transport.domain.Desempeño;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para gestionar las operaciones relacionadas con el desempeño.
 *
 * Esta clase expone endpoints para obtener información sobre desempeños
 * y para evaluar el desempeño.
 */
@RestController
@RequestMapping("/desempeño")
public class DesempeñoController {

    /**
     * Obtiene el desempeño por su identificador.
     *
     * @param id El identificador del desempeño que se desea obtener.
     * @return Una respuesta que contiene el desempeño solicitado en caso de éxito,
     *         o un código de error si no se encuentra el desempeño.
     */
    @GetMapping("/obtenerDesempeño")
    public ResponseEntity<Desempeño> obtenerDesempeño(String id) {
        return null;
    }

    /**
     * Evalúa el desempeño de un conductor o vehículo.
     *
     * @param desempeño El objeto {@link Desempeño} que se desea evaluar.
     * @return Una respuesta vacía con el código de estado 200 (OK) en caso de éxito,
     *         o un código de error si la operación falla.
     */
    @PostMapping("/evaluarDesempeño")
    public ResponseEntity<Void> evaluarDesempeño(Desempeño desempeño) {
        return null;
    }
}

