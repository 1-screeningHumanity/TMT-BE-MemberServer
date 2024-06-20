package com.example.TMTBEMemberServer.application.port.out.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MyNicknameRequestDto {

    private String nickanme;
    @Builder
    public MyNicknameRequestDto(String nickname) {
        this.nickanme = nickname;
    }
}
