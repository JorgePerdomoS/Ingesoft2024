package com.poli.ingesoft.transport.domain;

import lombok.Data;

import java.util.List;

@Data
public class Carga {

    private String id;
    private String descripcion;
    private String estado;
    private List<String> historial;

}
