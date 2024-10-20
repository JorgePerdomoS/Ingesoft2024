package com.poli.ingesoft.transport.service;

import com.poli.ingesoft.transport.domain.Desempeño;
import org.springframework.stereotype.Service;

/**
 * Interface que define los servicios relacionados con la evaluación y gestión del desempeño
 * en el sistema de transporte. Proporciona métodos para evaluar el desempeño de un empleado,
 * obtener los detalles de una evaluación de desempeño y guardar los resultados de la evaluación.
 */
@Service
public interface DesempeñoService {

    /**
     * Evalúa el desempeño de un empleado.
     * Este método debería incluir la lógica necesaria para evaluar el rendimiento
     * del personal según criterios predefinidos.
     */
    void evaluarDesempeño();

    /**
     * Obtiene los detalles de una evaluación de desempeño específica.
     *
     * @param desempeñoId el identificador único de la evaluación de desempeño.
     * @return la instancia de {@link Desempeño} que coincide con el ID proporcionado.
     */
    Desempeño optenerDesempeño(String desempeñoId);

    /**
     * Guarda o actualiza una evaluación de desempeño en el sistema.
     *
     * @param desempeñoId el identificador único de la evaluación de desempeño.
     * @return la instancia de {@link Desempeño} que ha sido guardada o actualizada.
     */
    Desempeño guardarDesempeño(String desempeñoId);
}
