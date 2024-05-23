package com.example.TMTBEMemberServer.application.service;

import com.example.TMTBEMemberServer.application.port.in.usecase.RandomNicknameUsecase;
import com.example.TMTBEMemberServer.application.port.out.outport.LoadRandomNicknamePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RandomNicknameService implements RandomNicknameUsecase {

    private final LoadRandomNicknamePort loadRandomNicknamePort;

    public void randomnicknameToss(){
        loadRandomNicknamePort.loadRandomNickname();

    }
}
