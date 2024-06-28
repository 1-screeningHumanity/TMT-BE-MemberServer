package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto.FeignClientNicknameResponseVo;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.MemberEntity;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.MemberJpaRepository;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.MemberQueryDslRepository;
import com.example.TMTBEMemberServer.application.port.out.dto.FeignClientNIcknameDto;
import com.example.TMTBEMemberServer.application.port.out.outport.LoadInfoport;
import com.example.TMTBEMemberServer.global.common.enumclass.Grade;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InfoAdaptor implements LoadInfoport {

    private final MemberQueryDslRepository memberQueryDslRepository;
    private final MemberJpaRepository memberJpaRepository;


    @Override
    public String myNickname(String uuid){
        String nickname = memberQueryDslRepository.myNickname(uuid);
        return nickname;

    }

    @Override
    public String myGrade(String uuid){
        Grade grade = memberQueryDslRepository.myGrade(uuid);
        String mygrade = grade.name();
        return mygrade;
    }

    @Override
    public FeignClientNicknameResponseVo getNicknameUuid(FeignClientNIcknameDto
            feignClientNIcknameDto){

        Optional<MemberEntity> memberEntity = memberJpaRepository
                .findByUuid(feignClientNIcknameDto.getUuid());

        String nickname = memberEntity.get().getNickname();
        FeignClientNicknameResponseVo feignClientNicknameResponseVo =
                FeignClientNicknameResponseVo
                        .builder()
                        .nickname(nickname)
                        .uuid(feignClientNIcknameDto.getUuid())
                        .build();

        return feignClientNicknameResponseVo;
    }
}
