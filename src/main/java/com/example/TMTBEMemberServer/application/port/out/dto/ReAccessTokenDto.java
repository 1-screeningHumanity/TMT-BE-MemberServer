package com.example.TMTBEMemberServer.application.port.out.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ReAccessTokenDto {


    private String AccessToken;


    @Builder
    public ReAccessTokenDto(String AccessToken) {
        this.AccessToken = AccessToken;
    }
}
