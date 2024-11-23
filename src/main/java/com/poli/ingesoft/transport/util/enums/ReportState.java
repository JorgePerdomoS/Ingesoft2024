package com.poli.ingesoft.transport.util.enums;

import lombok.Getter;

@Getter
public enum ReportState {

    ENTREGA(1),
    RECEPCION(2),
    EMERGENCIA(3);

    final Integer value;

    ReportState(Integer value) {
        this.value = value;
    }
}
