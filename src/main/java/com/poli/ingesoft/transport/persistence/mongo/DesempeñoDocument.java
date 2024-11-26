package com.poli.ingesoft.transport.persistence.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class DesempeñoDocument {

    private String id;
    private String conductorId;
    private double calificacion;

}
