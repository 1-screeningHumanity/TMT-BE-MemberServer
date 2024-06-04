package com.example.TMTBEMemberServer.application.service;


import com.example.TMTBEMemberServer.application.port.in.usecase.MyNicknameUsecase;
import com.example.TMTBEMemberServer.application.port.out.dto.MyNicknameRequestDto;
import com.example.TMTBEMemberServer.application.port.out.outport.LoadNicknameport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyNicknameService implements MyNicknameUsecase {


    private final LoadNicknameport laodNicknameport;


    @Override
    public MyNicknameRequestDto myNickname(String uuid){
        String nickname = laodNicknameport.myNickname(uuid);

        MyNicknameRequestDto myNicknameRequestDto = MyNicknameRequestDto.builder()
                .nickanme(nickname)
                .build();
        return myNicknameRequestDto;
    }

}
