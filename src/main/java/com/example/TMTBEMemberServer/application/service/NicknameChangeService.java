package com.example.TMTBEMemberServer.application.service;

import com.example.TMTBEMemberServer.application.port.in.usecase.NickNameChangeUsecase;
import com.example.TMTBEMemberServer.application.port.out.outport.SaveNicknameChangePort;
import com.example.TMTBEMemberServer.domain.NicknameChange;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NicknameChangeService implements NickNameChangeUsecase {

    private final SaveNicknameChangePort saveNicknameChangePort;



    public void nicknameChange(nicknameChangeRequestDto
            nicknameChangeRequestDto, String uuid){

        NicknameChange nicknameChange = NicknameChange.builder()
                .nickname(nicknameChangeRequestDto.getNickname())
                .uuid(uuid)
                .build();
        saveNicknameChangePort.saveNicknameChange(nicknameChange);

    }

}
