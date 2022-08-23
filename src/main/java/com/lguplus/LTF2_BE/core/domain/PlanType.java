package com.lguplus.LTF2_BE.core.domain;

import lombok.Getter;

@Getter
public enum PlanType {
    BASIC("1", "데이터 일반"),
    UNLIMITED("2", "데이터 무제한"),
    TEENAGER("3", "청소년"),
    SENIOR("4", "시니어"),
    DIRECT("5", "다이렉트");

    private String code;
    private String value;

    PlanType(String code, String value) {
        this.code = code;
        this.value = value;
    }
}