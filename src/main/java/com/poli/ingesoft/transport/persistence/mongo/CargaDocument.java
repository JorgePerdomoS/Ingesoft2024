package com.poli.ingesoft.transport.persistence.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class CargaDocument {

    private String id;
    private String descripcion;
    private String estado;
    private String temperatura;
    private String conductor;
    private boolean recepcionado;
    private String direccion;
}
