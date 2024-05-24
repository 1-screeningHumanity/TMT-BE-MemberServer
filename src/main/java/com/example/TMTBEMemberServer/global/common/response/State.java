package com.example.TMTBEMemberServer.global.common.response;

import lombok.Getter;

@Getter
public enum State {

    SIGNIN(),//회원가입한 회원
    SIGNUP(), //로그인한 회원
    SIGNOUT(),//로그아웃한 회원
    OUT();//탈퇴한 회원


}