package com.example.TMTBEMemberServer.application.port.out.outport;

import com.example.TMTBEMemberServer.application.port.out.dto.RandomNicknameDto;
import org.springframework.transaction.annotation.Transactional;

public interface LoadRandomNicknamePort {

    Boolean loadRandomNickname(RandomNicknameDto randomNicknameDto);
}
