package com.poli.ingesoft.transport.domain;

import lombok.Data;

import java.util.List;

@Data
public class Vehiculo {

    private String id;
    private String modelo;
    private String tipo;
    private Double capacidadCarga;
    private List<Sensor> sensoresConfig;

    public void actualizarUbicacion(){}
    public void reportarEstado(){}
}
