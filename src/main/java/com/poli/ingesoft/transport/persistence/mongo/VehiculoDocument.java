package com.poli.ingesoft.transport.persistence.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class VehiculoDocument {

    private String id;
    private String placa;
    private String modelo;
    private String tipo;
    private Double capacidadCarga;
    private List<SensorDocument> sensoresConfig;

}
