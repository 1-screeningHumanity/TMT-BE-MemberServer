package com.example.TMTBEMemberServer.global.common.enumclass;


import lombok.Getter;

@Getter
public enum PaymentType {

    CASH(1),//회원가입한 회원
    WON(2);//로그인한 회원

    private final int code;

    PaymentType(int code) {
        this.code = code;
    }

}
