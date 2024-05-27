package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.MemberJpaRepository;
import com.example.TMTBEMemberServer.application.port.out.dto.RandomNicknameDto;
import com.example.TMTBEMemberServer.application.port.out.outport.LoadRandomNicknamePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class RandomNicknameAdaptor implements LoadRandomNicknamePort {

    private final MemberJpaRepository memberJpaRepository;
    @Override
    @Transactional
    public Boolean loadRandomNickname(RandomNicknameDto randomNicknameDto) {
        return memberJpaRepository.existsByNickname(randomNicknameDto.getNickname());
    }

}
