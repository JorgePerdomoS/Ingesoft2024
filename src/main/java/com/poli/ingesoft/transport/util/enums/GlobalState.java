package com.poli.ingesoft.transport.util.enums;

import lombok.Getter;

@Getter
public enum GlobalState {

    OK(1),
    CREATE(2),
    ALREADY_EXIST(3),
    NOT_EXIST(4);

    final Integer value;

    GlobalState(Integer value){
        this.value = value;
    }
}
