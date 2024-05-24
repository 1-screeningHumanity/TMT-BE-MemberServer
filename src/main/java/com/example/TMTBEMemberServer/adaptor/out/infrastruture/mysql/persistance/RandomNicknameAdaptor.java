package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.SignUpJpaRepository;
import com.example.TMTBEMemberServer.application.port.out.dto.RandomNicknameDto;
import com.example.TMTBEMemberServer.application.port.out.outport.LoadRandomNicknamePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class RandomNicknameAdaptor implements LoadRandomNicknamePort {

    private final SignUpJpaRepository signUpJpaRepository;
    @Override
    @Transactional
    public Boolean loadRandomNickname(RandomNicknameDto randomNicknameDto) {
        if (signUpJpaRepository.existsByNickname(randomNicknameDto.getNickname())) {
            return true;
        }return false;
    }

}
