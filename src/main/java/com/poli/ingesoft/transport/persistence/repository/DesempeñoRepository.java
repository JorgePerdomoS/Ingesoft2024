package com.poli.ingesoft.transport.persistence.repository;

import com.poli.ingesoft.transport.persistence.mongo.DesempeñoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para realizar operaciones CRUD en la colección de desempeños en MongoDB.
 *
 * Esta interfaz extiende {@link MongoRepository} y proporciona métodos
 * para acceder y manipular documentos de desempeño.
 */
@Repository
public interface DesempeñoRepository extends MongoRepository<DesempeñoDocument, String> {

}
