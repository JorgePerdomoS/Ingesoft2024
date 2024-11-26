package com.poli.ingesoft.transport.domain;

import lombok.Data;

import java.util.List;

@Data
public class Emergencia {

    private Vehiculo vehiculo;
    private String tipoEmergencia;
    private List<Sensor> datosSensor;

}
