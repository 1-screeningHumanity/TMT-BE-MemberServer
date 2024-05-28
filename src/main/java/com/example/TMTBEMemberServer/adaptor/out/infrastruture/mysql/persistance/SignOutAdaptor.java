package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.MemberQueryDslRepository;
import com.example.TMTBEMemberServer.application.port.out.outport.LoadSignoutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SignOutAdaptor implements LoadSignoutPort {

    private final MemberQueryDslRepository memberQueryDslRepository;


    @Transactional
    public void statusLogout(String uuid){
        memberQueryDslRepository.changeStatusLogout(uuid);
    }

}
