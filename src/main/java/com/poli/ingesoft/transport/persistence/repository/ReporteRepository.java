package com.poli.ingesoft.transport.persistence.repository;

import com.poli.ingesoft.transport.persistence.mongo.ReporteDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para realizar operaciones CRUD en la colección de reportes en MongoDB.
 *
 * Esta interfaz extiende {@link MongoRepository} y proporciona métodos
 * para acceder y manipular documentos de reportes.
 */
@Repository
public interface ReporteRepository extends MongoRepository<ReporteDocument, String> {

}
