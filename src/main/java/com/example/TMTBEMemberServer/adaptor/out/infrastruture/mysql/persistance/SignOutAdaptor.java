package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.MemberQueryDslRepository;
import com.example.TMTBEMemberServer.application.port.out.outport.LoadSignoutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SignOutAdaptor implements LoadSignoutPort {

    private final MemberQueryDslRepository memberQueryDslRepository;

    public void statusLogout(String uuid){
        memberQueryDslRepository.changeStatusLogout(uuid);
    }

}
