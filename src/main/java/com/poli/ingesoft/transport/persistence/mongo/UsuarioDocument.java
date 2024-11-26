package com.poli.ingesoft.transport.persistence.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class UsuarioDocument {

    private String id;
    private String nombre;
    private String rol;
    private String contraseña;
    private String nombreUsuario;
    private String documento;
    private Double calificacion;
}
