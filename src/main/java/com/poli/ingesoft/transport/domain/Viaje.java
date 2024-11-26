package com.poli.ingesoft.transport.domain;

import lombok.Data;

@Data
public class Viaje {

    private Vehiculo vehiculo;
    private Carga carga;
    private String ruta;
    private String detalles;

}
