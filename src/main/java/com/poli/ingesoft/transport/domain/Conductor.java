package com.poli.ingesoft.transport.domain;

import lombok.Data;

import java.util.List;

@Data
public class Conductor {
    private String id;
    private String nombre;
    private List<Desempeño> evaluaciones;

    public void reportarEntrega(){}
    public void consultarRuta(){}
}
