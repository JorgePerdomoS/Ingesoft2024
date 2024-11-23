package com.poli.ingesoft.transport.persistence.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class ConductorDocument {

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
