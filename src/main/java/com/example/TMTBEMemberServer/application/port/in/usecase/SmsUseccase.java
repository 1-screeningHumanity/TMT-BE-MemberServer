package com.example.TMTBEMemberServer.application.port.in.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;

public interface SmsUseccase {
    SingleMessageSentResponse sendOne(SmsRequestDto smsRequestDto);

    void verifySms(SmsVerifyRequestDto smsVerifyRequestDto);

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class SmsRequestDto{
        private String phoneNumber;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class SmsVerifyRequestDto{
        private String phoneNumber;
        private String verifyCode;

    }

}
