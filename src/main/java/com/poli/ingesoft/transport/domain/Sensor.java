package com.poli.ingesoft.transport.domain;

import lombok.Data;

@Data
public class Sensor {

    private String id;
    private String tipo;
    private Double valor;

    public Double leerValor() {
        return valor;
    }
}
