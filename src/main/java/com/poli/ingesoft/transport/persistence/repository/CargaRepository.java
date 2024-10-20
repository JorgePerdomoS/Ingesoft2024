package com.poli.ingesoft.transport.persistence.repository;

import com.poli.ingesoft.transport.persistence.mongo.CargaDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para realizar operaciones CRUD en la colección de cargas en MongoDB.
 *
 * Esta interfaz extiende {@link MongoRepository} y proporciona métodos
 * para acceder y manipular documentos de carga.
 */
@Repository
public interface CargaRepository extends MongoRepository<CargaDocument, String> {
}
