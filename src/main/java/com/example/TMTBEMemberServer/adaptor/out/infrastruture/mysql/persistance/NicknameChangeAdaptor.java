package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.MemberQueryDslRepository;
import com.example.TMTBEMemberServer.application.port.out.outport.SaveNicknameChangePort;
import com.example.TMTBEMemberServer.domain.NicknameChange;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class NicknameChangeAdaptor implements SaveNicknameChangePort {

    private final MemberQueryDslRepository memberQueryDslRepository;


    @Override
    @Transactional
    public void saveNicknameChange(NicknameChange nicknameChange){
        String uuid = nicknameChange.getUuid();
        memberQueryDslRepository.nicknameChange(nicknameChange);
    }

}
