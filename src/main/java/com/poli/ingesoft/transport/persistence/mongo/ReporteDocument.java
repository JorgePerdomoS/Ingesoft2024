package com.poli.ingesoft.transport.persistence.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ReporteDocument {
    private String id;
    private String tipoReporte;
    private String datos;
}
