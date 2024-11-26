package com.poli.ingesoft.transport.util.enums;

import lombok.Getter;

@Getter
public enum ReportState {

    ENTREGA("ENTREGA"),
    RECEPCION("RECEPCION"),
    EMERGENCIA("EMERGENCIA"),;

    final String value;

    ReportState(String value) {
        this.value = value;
    }
}
