package com.poli.ingesoft.transport.domain;

import lombok.Data;

@Data
public class GPS {

    private String id;
    private String ubicacion;


    public String obtenerUbicacion() {
        return this.ubicacion;
    }

}
