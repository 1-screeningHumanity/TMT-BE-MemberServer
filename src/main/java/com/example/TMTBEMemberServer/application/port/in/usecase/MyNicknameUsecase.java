package com.example.TMTBEMemberServer.application.port.in.usecase;

import com.example.TMTBEMemberServer.application.port.out.dto.MyNicknameRequestDto;

public interface MyNicknameUsecase {

    MyNicknameRequestDto myNickname(String uuid);
}
