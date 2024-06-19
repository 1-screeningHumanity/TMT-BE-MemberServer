package com.example.TMTBEMemberServer.application.port.in.usecase;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto.GradeinfoResponseDto;
import com.example.TMTBEMemberServer.application.port.out.dto.MyNicknameRequestDto;

public interface MyInfoUsecase {

    MyNicknameRequestDto myNickname(String uuid);

    GradeinfoResponseDto myGrade(String uuid);
}
