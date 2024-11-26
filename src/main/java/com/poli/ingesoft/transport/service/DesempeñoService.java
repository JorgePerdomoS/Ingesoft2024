package com.poli.ingesoft.transport.service;

import com.poli.ingesoft.transport.domain.Desempeño;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface que define los servicios relacionados con la evaluación y gestión del desempeño
 * en el sistema de transporte. Proporciona métodos para evaluar el desempeño de un empleado,
 * obtener los detalles de una evaluación de desempeño y guardar los resultados de la evaluación.
 */
@Service
public interface DesempeñoService {

    /**
     * Obtiene el desempeño del conductor.
     * Este método recibe el documento de identificación del conductor como
     * parámetro y devuelve una lista con su desempeño, que incluye métricas
     * relevantes relacionadas con su historial de trabajo.
     *
     * @param documentoConductor El número de identificación del conductor.
     * @return Una lista de objetos de tipo Desempeño que contienen información
     * detallada sobre el desempeño del conductor.
     */
    List<Desempeño> obtenerDesempeño(String documentoConductor);

    /**
     * Guarda o actualiza una evaluación de desempeño en el sistema.
     *
     * @param desempeñoId el identificador único de la evaluación de desempeño.
     * @return la instancia de {@link Desempeño} que ha sido guardada o actualizada.
     */
    Integer guardarDesempeño(Desempeño desempeñoId);
}
