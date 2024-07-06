package com.example.TMTBEMemberServer.adaptor.in.web.controller;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto.FeignClientNicknameResponseVo;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto.GradeinfoResponseDto;
import com.example.TMTBEMemberServer.application.port.in.usecase.FeignClientUsecase;
import com.example.TMTBEMemberServer.application.port.in.usecase.MyInfoUsecase;
import com.example.TMTBEMemberServer.application.port.out.dto.MyNicknameRequestDto;
import com.example.TMTBEMemberServer.global.common.response.BaseResponse;
import com.example.TMTBEMemberServer.global.common.token.DecodingToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
@Validated
public class MypageController {

    private final DecodingToken decodingToken;
    private final MyInfoUsecase myInfoUsecase;
    private final FeignClientUsecase feignClientUsecase;

    @GetMapping ("/mypage/information")
    public BaseResponse<MyNicknameRequestDto> myNickname(@RequestHeader("Authorization") String jwt) {

        String uuid = decodingToken.getUuid(jwt);
        MyNicknameRequestDto myNicknameRequestDto = myInfoUsecase.myNickname(uuid);
        return new BaseResponse<>(myNicknameRequestDto);
    }

    @GetMapping("/grade")
    public BaseResponse<GradeinfoResponseDto> myGrade(@RequestHeader("Authorization") String jwt) {
        String uuid = decodingToken.getUuid(jwt);

        GradeinfoResponseDto gradeinfoResponseDto = myInfoUsecase.myGrade(uuid);
        return new BaseResponse<>(gradeinfoResponseDto);
    }

    @GetMapping("/nickname-uuid") //feignClient 요청 처리
    public BaseResponse<FeignClientNicknameResponseVo> getMemberUuid(
            @RequestParam("nickname") String nickname){

        FeignClientNicknameResponseVo feignClientNicknameResponseVo =
                feignClientUsecase.getNicknameUuid( FeignClientUsecase.UuidRequestDto.builder()
                        .nickname(nickname)
                        .build());

        log.info("uuid={}",feignClientNicknameResponseVo.getUuid());
        log.info("nickname={}",feignClientNicknameResponseVo.getNickname());

        return new BaseResponse<>(feignClientNicknameResponseVo);
    }

}
