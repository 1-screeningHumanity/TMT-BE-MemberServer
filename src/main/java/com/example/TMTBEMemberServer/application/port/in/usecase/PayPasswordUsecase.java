package com.example.TMTBEMemberServer.application.port.in.usecase;

import com.example.TMTBEMemberServer.domain.PayPassword;
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

}
