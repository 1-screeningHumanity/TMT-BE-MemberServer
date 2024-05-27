package com.example.TMTBEMemberServer.adaptor.in.web.controller;

import com.example.TMTBEMemberServer.adaptor.in.web.vo.PayPasswordRequestVo;
import com.example.TMTBEMemberServer.adaptor.in.web.vo.SignUpRequestVo;
import com.example.TMTBEMemberServer.application.port.in.usecase.PayPasswordUsecase;
import com.example.TMTBEMemberServer.application.port.in.usecase.RandomNicknameUsecase;
import com.example.TMTBEMemberServer.application.port.in.usecase.SignUpUsecase;
import com.example.TMTBEMemberServer.application.port.out.dto.RandomNicknameDto;
import com.example.TMTBEMemberServer.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
@Validated
public class MemberController {

    private final ModelMapper modelMapper;
    private final SignUpUsecase signUpUsecase;
    private final RandomNicknameUsecase randomNicknameUsecase;
    private final PayPasswordUsecase payPasswordUsecase;
    @PostMapping("/signup") //회원가입
    public BaseResponse<Void> SignUp(@RequestBody SignUpRequestVo signUpRequestVo) {

        signUpUsecase.SignUp(modelMapper.map(signUpRequestVo, SignUpUsecase.SignUpRequiredDto.class));
        return new BaseResponse<>();

    }

    @GetMapping("/random-nickname") //랜덤 닉네임생성
    public BaseResponse<String> randomNickName() {

        randomNicknameUsecase.createRamdomNickName();
        RandomNicknameDto randomNicknameDto = randomNicknameUsecase.createRamdomNickName();
        String result = randomNicknameDto.getNickname();
        return new BaseResponse<>(result);


    }

    @PostMapping("/pay-password")//결제 비밀번호 설정
    public BaseResponse<Void> payPassword(@RequestBody PayPasswordRequestVo payPasswordRequestVo) {
        payPasswordUsecase.payPasswordUpdate(modelMapper.map(payPasswordRequestVo,
                PayPasswordUsecase.payPasswordRequestDto.class));
        return new BaseResponse<>();

    }

}
