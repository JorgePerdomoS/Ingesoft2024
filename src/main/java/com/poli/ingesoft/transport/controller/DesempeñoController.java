package com.poli.ingesoft.transport.controller;

import com.poli.ingesoft.transport.domain.Desempeño;
import com.poli.ingesoft.transport.service.DesempeñoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con el desempeño.
 *
 * Esta clase expone endpoints para obtener información sobre desempeños
 * y para evaluar el desempeño.
 */
@RestController
@RequestMapping("/desempeño")
public class DesempeñoController {

    private final DesempeñoService desempeñoService;

    @Autowired
    public DesempeñoController(DesempeñoService desempeñoService){
        this.desempeñoService = desempeñoService;
    }

    /**
     * Obtiene el desempeño por su identificador.
     *
     * @param id El identificador del desempeño que se desea obtener.
     * @return Una respuesta que contiene el desempeño solicitado en caso de éxito,
     *
     */
    @GetMapping("/obtenerDesempeño/{id}")
    public ResponseEntity<List<Desempeño>> obtenerDesempeño(@PathVariable String id) {
        List<Desempeño> response = desempeñoService.obtenerDesempeño(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Evalúa el desempeño de un conductor o vehículo.
     *
     * @param desempeño El objeto {@link Desempeño} que se desea evaluar.
     * @return Una respuesta vacía con el código de estado 200 (OK) en caso de éxito,
     *         o un código de error si la operación falla.
     * @return  estado OK.
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/evaluarDesempeno")
    public ResponseEntity<Integer> evaluarDesempeño(@RequestBody Desempeño desempeño) {
        Integer response = desempeñoService.guardarDesempeño(desempeño);
        return ResponseEntity.ok(response);
    }
}

