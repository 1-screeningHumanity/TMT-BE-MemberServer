package com.example.TMTBEMemberServer.application.port.in.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public interface PayPasswordUsecase {


    void payPasswordUpdate(payPasswordRequestDto payPasswordRequestDto);
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class payPasswordRequestDto{
        private String nickname;
        private String payingPassword;
    }

    void payPasswordCheck(payPasswordCheckRequestDto payPasswordCheckRequestDto, String uuid);
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class payPasswordCheckRequestDto{
        private String payingPassword;
    }

}
