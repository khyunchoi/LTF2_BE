package com.lguplus.LTF2_BE.core.domain;

import lombok.Getter;

@Getter
public enum TelecomTech {
    LTE(1, "LTE"),
    G3(2, "3G"),
    G4(3, "4G"),
    G5(4, "5G");

    private Integer code;
    private String value;

    TelecomTech(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
