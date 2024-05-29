package com.example.TMTBEMemberServer.application.service;

import com.example.TMTBEMemberServer.application.port.in.usecase.SmsUseccase;
import com.example.TMTBEMemberServer.global.common.exception.CustomException;
import com.example.TMTBEMemberServer.global.common.response.BaseResponseCode;
import java.util.Random;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService implements SmsUseccase {

    private final DefaultMessageService messageService;
    private final SmsMessageAuth smsMessageAuth;
    private final String fromNumber;

    public SmsService (@Value("${spring.COOLSMS.KEY}")String apiKey,
            @Value("${spring.COOLSMS.SECRET}")String apiSecret,
            @Value("${spring.COOLSMS.FROM}")String fromNumber, SmsMessageAuth smsMessageAuth){

        this.messageService = NurigoApp.INSTANCE.initialize(apiKey,apiSecret,"https://api.coolsms.co.kr");
        this.smsMessageAuth = smsMessageAuth;
        this.fromNumber = fromNumber;

    }

    public String createRandomNum(){ //인증번호 생성
        Random rand = new Random();

        StringBuilder randomNum = new StringBuilder();
        for (int i = 0; i < 4; i++) { //10에서 랜덤 4자리 생성
            String random = Integer.toString(rand.nextInt(10));
            randomNum.append(random);
        }
        return randomNum.toString();
    }
    @Override
    public SingleMessageSentResponse sendOne(SmsRequestDto smsRequestDto){

        String verifyCode = createRandomNum();
        String recivedPhoneNum = smsRequestDto.getPhoneNumber();

        Message message = new Message();
        message.setFrom(fromNumber);
        message.setTo(recivedPhoneNum);
        message.setText(String.format("티끌모의투자 인증번호 [%s]를 입력해주세요.", verifyCode));

        smsMessageAuth.createSmsCertification(recivedPhoneNum, verifyCode);

        return messageService.sendOne(new SingleMessageSendingRequest(message));

    }
    @Override
    public void verifySms(SmsVerifyRequestDto smsVerifyRequestDto) {
        if (!isVerify(smsVerifyRequestDto)) {
            throw new CustomException(BaseResponseCode.WRONG_VARIFYCODE);
        }
        smsMessageAuth.deleteSmsCertification(smsVerifyRequestDto.getPhoneNumber());
    }

    private boolean isVerify(SmsVerifyRequestDto requestDto) {
        return (smsMessageAuth.hasKey(requestDto.getPhoneNumber()) &&
                smsMessageAuth.getSmsCertification(requestDto.getPhoneNumber())
                        .equals(requestDto.getVerifyCode()));
        // 폰 넘버가 key값으로 redis에 있고 && redis에 저장된 인증번호와 이용자 입력번호가 일치한다면 true
    }

}
