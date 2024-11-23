package com.poli.ingesoft.transport.domain;

import lombok.Data;

import java.util.List;

@Data
public class Desempeño {

    private String id;
    private String conductorId;
    private double calificacion;
    //metodo
    private List<String> historialEvaluaciones;

    public void evaluarDesempeño(){}
}
