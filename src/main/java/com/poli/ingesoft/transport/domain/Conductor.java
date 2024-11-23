package com.poli.ingesoft.transport.domain;

import lombok.Data;

import java.util.List;

@Data
public class Conductor {
    private String id;
    private String nombre;
    private String rol;
    private String contraseña;
    private String nombreUsuario;
    private String documento;
    private Double calificacion;

    public void reportarEntrega(){}
    public void consultarRuta(){}
}
