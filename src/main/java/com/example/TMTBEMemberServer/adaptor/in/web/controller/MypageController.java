package com.example.TMTBEMemberServer.adaptor.in.web.controller;

import com.example.TMTBEMemberServer.application.port.in.usecase.MyNicknameUsecase;
import com.example.TMTBEMemberServer.application.port.out.dto.MyNicknameRequestDto;
import com.example.TMTBEMemberServer.global.common.response.BaseResponse;
import com.example.TMTBEMemberServer.global.common.token.DecodingToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
@Validated
public class MypageController {

    private final DecodingToken decodingToken;
    private final MyNicknameUsecase myNicknameUsecase;


    @GetMapping ("/mypage/information")
    public BaseResponse<MyNicknameRequestDto> myNickname(@RequestHeader("Authorization") String jwt) {

        String uuid = decodingToken.getUuid(jwt);
        MyNicknameRequestDto myNicknameRequestDto = myNicknameUsecase.myNickname(uuid);
        return new BaseResponse<>(myNicknameRequestDto);
    }

}
