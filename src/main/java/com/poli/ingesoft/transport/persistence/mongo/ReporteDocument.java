package com.poli.ingesoft.transport.persistence.mongo;

import com.poli.ingesoft.transport.util.enums.ReportState;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ReporteDocument {
    private String id;
    private ReportState tipoReporte;
    private String descripcionReporte;
    private String datos;
}
