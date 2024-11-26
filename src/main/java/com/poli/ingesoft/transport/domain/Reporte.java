package com.poli.ingesoft.transport.domain;

import com.poli.ingesoft.transport.util.enums.ReportState;
import lombok.Data;

@Data
public class Reporte {


    private ReportState tipoReporte;
    private String descripcionReporte;
    private String datos;
}
