package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.MemberQueryDslRepository;
import com.example.TMTBEMemberServer.application.port.out.outport.LoadNicknameport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyInfoAdaptor implements LoadNicknameport {

    private final MemberQueryDslRepository memberQueryDslRepository;


    @Override
    public String myNickname(String uuid){
        String nickname = memberQueryDslRepository.myNickname(uuid);
        return nickname;

    }
}
