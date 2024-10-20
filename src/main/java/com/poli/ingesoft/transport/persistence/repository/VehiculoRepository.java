package com.poli.ingesoft.transport.persistence.repository;

import com.poli.ingesoft.transport.persistence.mongo.VehiculoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para realizar operaciones CRUD en la colección de vehículos en MongoDB.
 *
 * Esta interfaz extiende {@link MongoRepository} y proporciona métodos
 * para acceder y manipular documentos de vehículos.
 */
@Repository
public interface VehiculoRepository extends MongoRepository<VehiculoDocument, String> {
}