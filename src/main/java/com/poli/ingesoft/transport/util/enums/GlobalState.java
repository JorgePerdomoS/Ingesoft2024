package com.poli.ingesoft.transport.util.enums;

public enum GlobalState {

    CREATE(1),
    ALREADY_EXIST(2),
    NOT_EXIST(3);

    final Integer value;

    GlobalState(Integer value){
        this.value = value;
    }
}
