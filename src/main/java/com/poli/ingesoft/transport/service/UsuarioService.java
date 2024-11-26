package com.poli.ingesoft.transport.service;

import com.poli.ingesoft.transport.domain.Usuario;
import com.poli.ingesoft.transport.domain.Reporte;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface que define los servicios relacionados con la gestión de conductores en el sistema de transporte.
 * Proporciona métodos para obtener información de un conductor, guardar datos de un conductor,
 * reportar entregas realizadas y consultar rutas asignadas.
 */
@Service
public interface UsuarioService {

    /**
     * Obtiene los detalles de un conductor en función de su identificador.
     *
     * @param idConductor el identificador único del conductor.
     * @return la instancia de {@link Usuario} que coincide con el ID proporcionado.
     */
    Usuario obtenerConductor(String idConductor);

    /**
     * Guarda o persiste una instancia de conductor en el sistema.
     *
     * @param usuario la instancia de {@link Usuario} que se debe guardar.
     */
    Integer guardarConductor(Usuario usuario);

    /**
     * Reporta la entrega realizada por el conductor.
     * Este método debería incluir la lógica necesaria para actualizar el estado
     * de la entrega.
     */
    void generarReporte(Reporte reporte);


    List<Usuario> obtenerUsuarios();

}
