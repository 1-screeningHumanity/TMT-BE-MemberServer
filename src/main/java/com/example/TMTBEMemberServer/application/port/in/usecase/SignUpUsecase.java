package com.example.TMTBEMemberServer.application.port.in.usecase;

import com.example.TMTBEMemberServer.application.port.out.dto.SignUpDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
public interface SignUpUsecase {

    SignUpDto SignUp(SignUpRequiredDto signUpReqiuredDto);
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class SignUpRequiredDto{
        private String name;
        private String password;
        private String phoneNumber;
        private String nickname;

    }

}
