package com.example.TMTBEMemberServer.application.port.in.usecase;

import com.example.TMTBEMemberServer.application.port.out.dto.RandomNicknameDto;

public interface RandomNicknameUsecase {

    RandomNicknameDto createRamdomNickName();
    void randomnicknameFalse(Boolean result);

}
