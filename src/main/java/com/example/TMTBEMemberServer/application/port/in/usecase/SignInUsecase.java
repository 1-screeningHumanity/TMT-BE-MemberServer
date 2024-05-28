package com.example.TMTBEMemberServer.application.port.in.usecase;

import com.example.TMTBEMemberServer.application.port.out.dto.SignInResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface SignInUsecase {
    SignInResponseDto SigninService(SigninRequestDto signinRequestDto);

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class SigninRequestDto{

        private String name;
        private String password;
        private String phoneNumber;
    }

}
