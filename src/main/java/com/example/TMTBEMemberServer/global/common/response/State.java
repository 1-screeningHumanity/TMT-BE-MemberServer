package com.example.TMTBEMemberServer.global.common.response;

import lombok.Getter;

@Getter
public enum State {

    SIGNUP(1),//회원가입한 회원
    SIGNIN(2), //로그인한 회원
    SIGNOUT(3),//로그아웃한 회원
    OUT(4);//탈퇴한 회원

    private final int code;

    State(int code) {
        this.code = code;
    }
    
}
