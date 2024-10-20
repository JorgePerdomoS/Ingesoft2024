package com.poli.ingesoft.transport.persistence.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class GPSDocument {

    private String id;
    private String ubicacion;


    public String obtenerUbicacion() {
        return this.ubicacion;
    }

}
