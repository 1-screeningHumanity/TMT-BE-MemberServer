package com.example.TMTBEMemberServer.application.port.out.outport;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto.FeignClientNicknameResponseVo;
import com.example.TMTBEMemberServer.application.port.out.dto.FeignClientNicknameDto;

public interface LoadInfoport {

    String myNickname(String uuid);


    String myGrade(String uuid);

    FeignClientNicknameResponseVo getNicknameUuid(FeignClientNicknameDto
            feignClientNIcknameDto);
}
