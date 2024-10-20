package com.poli.ingesoft.transport.persistence.repository;

import com.poli.ingesoft.transport.persistence.mongo.ViajeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio que gestiona las operaciones de persistencia para los documentos de viaje
 * en una base de datos MongoDB. Extiende la interfaz {@link MongoRepository} para proporcionar
 * métodos estándar de acceso y manipulación de datos.
 *
 * La entidad gestionada es {@link ViajeDocument}, y el identificador es de tipo {@link String}.
 */
@Repository
public interface ViajeRepository extends MongoRepository<ViajeDocument, String> {
}
