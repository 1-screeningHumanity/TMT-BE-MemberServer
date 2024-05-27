package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;


import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.MemberQueryDslRepository;
import com.example.TMTBEMemberServer.application.port.out.outport.DeleteAccountPort;
import com.example.TMTBEMemberServer.domain.DeleteAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DeleteAccountAdaptor implements DeleteAccountPort {

    private final MemberQueryDslRepository memberQueryDslRepository;


    @Transactional
    public void deleteAccount(DeleteAccount deleteAccount){

        String uuid = deleteAccount.getUuid();
        memberQueryDslRepository.changeStatusOut(uuid);

    }
}
