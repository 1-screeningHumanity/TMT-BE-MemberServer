package com.example.TMTBEMemberServer.adaptor.in.web.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignInResponseVo {

    private String name;
    private String accessToken;
    private String refreshToken;

    @Builder
    public SignInResponseVo(String name, String accessToken, String refreshToken) {
        this.name = name;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
