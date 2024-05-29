package com.example.TMTBEMemberServer.adaptor.in.web.controller;


import com.example.TMTBEMemberServer.adaptor.in.web.vo.CoolSmsRequestVo;
import com.example.TMTBEMemberServer.adaptor.in.web.vo.CoolSmsVerifyRequestVo;
import com.example.TMTBEMemberServer.application.port.in.usecase.SmsUseccase;
import com.example.TMTBEMemberServer.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SendController {

    private final SmsUseccase smsUseccase;
    private final ModelMapper modelMapper;

    @PostMapping("/sms/send")//전화번호 요청을 받음.
    public BaseResponse<Void> sendSms(@RequestBody CoolSmsRequestVo coolSmsRequestVo) {
        smsUseccase.sendOne(modelMapper.map(coolSmsRequestVo,
                SmsUseccase.SmsRequestDto.class));
        return new BaseResponse<>();
    }

    @PostMapping("/sms/verify")//인증번호 인증
    public BaseResponse<Void>  verifySms(@RequestBody CoolSmsVerifyRequestVo CoolSmsVerifyRequestVo) {
        smsUseccase.verifySms(modelMapper.map(CoolSmsVerifyRequestVo,
                SmsUseccase.SmsVerifyRequestDto.class));
        return new BaseResponse<>();
    }

}
