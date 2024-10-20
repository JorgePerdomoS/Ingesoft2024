package com.poli.ingesoft.transport.persistence.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class SensorDocument {

    private String id;
    private String tipo;
    private Double valor;

    public Double leerValor() {
        return valor;
    }
}
