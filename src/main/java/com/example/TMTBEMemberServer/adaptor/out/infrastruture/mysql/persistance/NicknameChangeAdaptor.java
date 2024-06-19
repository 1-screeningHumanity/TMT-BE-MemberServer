package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto.NicknameKafkaProducerDto;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.MemberEntity;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.MemberJpaRepository;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.MemberQueryDslRepository;
import com.example.TMTBEMemberServer.application.port.out.outport.SaveNicknameChangePort;
import com.example.TMTBEMemberServer.domain.NicknameChange;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class NicknameChangeAdaptor implements SaveNicknameChangePort {

    private final MemberQueryDslRepository memberQueryDslRepository;
    private final MemberJpaRepository memberJpaRepository;


    @Override
    public void saveNicknameChange(NicknameChange nicknameChange){

        String uuid = nicknameChange.getUuid();
        Optional<MemberEntity> member = memberJpaRepository.findByUuid(uuid);
        String beforeNickname = member.get().getNickname();

        NicknameKafkaProducerDto nicknameKafkaProducerDto = NicknameKafkaProducerDto
                .builder()
                .beforeNickName(beforeNickname)
                .afterNickName(nicknameChange.getNickname())
                .build();

        memberQueryDslRepository.nicknameChange(nicknameKafkaProducerDto);
    }

}
