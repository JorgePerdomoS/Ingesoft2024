package com.poli.ingesoft.transport.persistence.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ViajeDocument {

    private String id;
    private VehiculoDocument vehiculo;
    private CargaDocument carga;
    private String ruta;
    private String detalles;

    public void iniciarViaje(){}
    public void finalizarViaje(){}

}
