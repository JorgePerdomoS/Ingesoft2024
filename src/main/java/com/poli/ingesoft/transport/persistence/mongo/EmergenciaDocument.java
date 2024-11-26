package com.poli.ingesoft.transport.persistence.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class EmergenciaDocument {

    private String id;
    private VehiculoDocument vehiculo;
    private String tipoEmergencia;
    private List<SensorDocument> datosSensor;
}
