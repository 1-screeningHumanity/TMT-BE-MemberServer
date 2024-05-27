package com.example.TMTBEMemberServer.application.port.in.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface PasswordChangeUsecase {
    void passwordChange(passwordChangeRequestDto passwordChangeRequestDto, String uuid);

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class passwordChangeRequestDto{
        private String password;

    }


}
