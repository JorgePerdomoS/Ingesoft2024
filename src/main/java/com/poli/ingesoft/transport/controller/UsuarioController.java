package com.poli.ingesoft.transport.controller;

import com.poli.ingesoft.transport.domain.Usuario;
import com.poli.ingesoft.transport.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    /**
     * Obtiene un usuario por su identificador.
     *
     * @param documento El identificador del vehículo que se desea obtener.
     * @return Una respuesta que contiene el vehículo solicitado en caso de éxito,
     * o un código de error si no se encuentra el vehículo.
     */
    @GetMapping("/obtenerUsuario/{documento}")
    public ResponseEntity<Usuario> obtenerVehiculo(@PathVariable String documento) {
        Usuario response = usuarioService.obtenerConductor(documento);
        if (response == null) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(204));
        }
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }

    /**
     * Registra un nuevo usuario.
     *
     * @param usuario El objeto {@link Usuario} que se desea registrar.
     * @return Una respuesta vacía con el código de estado 201 (Creado) en caso de éxito,
     * o un código de error si la operación falla.
     */
    @PostMapping("/registrarUsuario")
    public ResponseEntity<Integer> guardarVehiculo(@RequestBody Usuario usuario) {
        Integer response = usuarioService.guardarConductor(usuario);
        return  ResponseEntity.ok(response);
    }

    /**
     * Obtiene la lista de usuarios registrados.
     * <p>
     * Este método proporciona una lista completa de los usuarios almacenados en el sistema.
     * Los datos se recuperan a través del servicio {@link UsuarioService}.
     *
     * @return Una respuesta con una lista de objetos {@link Usuario} y el código de estado HTTP 200 (OK)
     * si la operación se realiza con éxito. Si ocurre un error inesperado, se devolverá un código HTTP 500 (Error Interno del Servidor).
     */
    @GetMapping("/obtenerUsuarios")
    public ResponseEntity<List<Usuario>> listarVehiculos() {
        List<Usuario> response = usuarioService.obtenerUsuarios();
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));

    }
}
