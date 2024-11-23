package com.poli.ingesoft.transport.persistence.repository;

import com.poli.ingesoft.transport.persistence.mongo.ConductorDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio para realizar operaciones CRUD en la colección de conductores en MongoDB.
 *
 * Esta interfaz extiende {@link MongoRepository} y proporciona métodos
 * para acceder y manipular documentos de conductores.
 */
@Repository
public interface ConductorRepository extends MongoRepository<ConductorDocument, String> {

    Optional<ConductorDocument> findByDocumento(String documento);
}
