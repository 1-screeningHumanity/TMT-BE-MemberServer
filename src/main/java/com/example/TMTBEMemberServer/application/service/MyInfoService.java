package com.example.TMTBEMemberServer.application.service;


import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto.GradeinfoResponseDto;
import com.example.TMTBEMemberServer.application.port.in.usecase.MyInfoUsecase;
import com.example.TMTBEMemberServer.application.port.out.dto.MyNicknameRequestDto;
import com.example.TMTBEMemberServer.application.port.out.outport.LoadMyInfoport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyInfoService implements MyInfoUsecase {


    private final LoadMyInfoport loadMyInfoport;


    @Override
    public MyNicknameRequestDto myNickname(String uuid){
        String nickname = loadMyInfoport.myNickname(uuid);

        MyNicknameRequestDto myNicknameRequestDto = MyNicknameRequestDto.builder()
                .nickanme(nickname)
                .build();
        return myNicknameRequestDto;
    }

    @Override
    public GradeinfoResponseDto myGrade(String uuid){
        String grade = loadMyInfoport.myGrade(uuid);
        GradeinfoResponseDto gradeinfoResponseDto = GradeinfoResponseDto
                .builder().
                grade(grade).build();

        return gradeinfoResponseDto;
    }
}
