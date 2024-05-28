package com.example.TMTBEMemberServer.application.port.out.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignInResponseDto {

    private String name;
    private String accessToken;
    private String refreshToken;

    @Builder
    public SignInResponseDto(String name, String phoneNumber, String password, String accessToken,
            String refreshToken) {
        this.name = name;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
