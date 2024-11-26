package com.poli.ingesoft.transport.domain;

import lombok.Data;

@Data
public class Usuario {

    private String nombre;
    private String rol;
    private String contraseña;
    private String nombreUsuario;
    private String documento;
    private Double calificacion;

}
