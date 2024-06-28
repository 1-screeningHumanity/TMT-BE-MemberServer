package com.example.TMTBEMemberServer.application.port.in.usecase;

import com.example.TMTBEMemberServer.adaptor.in.web.vo.PasswordChangeWithoutAuthRequestVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface PasswordChangeUsecase {
    void passwordChange(passwordChangeRequestDto passwordChangeRequestDto, String uuid);

    void passwordChangeWithoutAuth(PasswordChangeWithoutAuthRequestVo requestVo);

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class passwordChangeRequestDto{
        private String password;

    }


}
