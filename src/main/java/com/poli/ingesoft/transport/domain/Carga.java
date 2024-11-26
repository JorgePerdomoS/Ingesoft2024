package com.poli.ingesoft.transport.domain;

import lombok.Data;

import java.util.List;

@Data
public class Carga {

    private String descripcion;
    private String estado;
    private String temperatura;
    private String conductor;
    private boolean recepcionado;
    private String direccion;

}
