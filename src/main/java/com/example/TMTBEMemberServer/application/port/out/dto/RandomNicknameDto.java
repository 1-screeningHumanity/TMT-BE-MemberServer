package com.example.TMTBEMemberServer.application.port.out.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RandomNicknameDto {
    private String nickname;

    @Builder
    public RandomNicknameDto(String nickname) {
        this.nickname = nickname;
    }
}
