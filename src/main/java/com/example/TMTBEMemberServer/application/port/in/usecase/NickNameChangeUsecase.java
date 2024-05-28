package com.example.TMTBEMemberServer.application.port.in.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface NickNameChangeUsecase {

    void nicknameChange(nicknameChangeRequestDto
            nicknameChangeRequestDto, String uuid);




    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class nicknameChangeRequestDto{
        private String nickname;

    }

}
