package com.example.TMTBEMemberServer.application.port.in.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface PayPasswordChangeUsecase {


    void changePaypassword(PaypasswordChangeRequestDto paypasswordChangeRequestDto,
            String uuid);



    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class PaypasswordChangeRequestDto{
        private String payingPassword;

    }



}
