package com.example.TMTBEMemberServer.global.common.enumclass;

import lombok.Getter;

@Getter
public enum PaymentMethod {

    KAKAOPAY(1),//카카오페이
    KFTC(2);//금융결제원

    private final int code;

    PaymentMethod(int code) {
        this.code = code;
    }
}
