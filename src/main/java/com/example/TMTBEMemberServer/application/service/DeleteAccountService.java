package com.example.TMTBEMemberServer.application.service;


import com.example.TMTBEMemberServer.application.port.in.usecase.DeleteAccountUsecase;
import com.example.TMTBEMemberServer.application.port.out.outport.DeleteAccountPort;
import com.example.TMTBEMemberServer.domain.DeleteAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteAccountService implements DeleteAccountUsecase {

    private final DeleteAccountPort deleteAccountPort;
    public void deleteAccountService(String uuid){

        DeleteAccount deleteAccount = DeleteAccount
                .builder().uuid(uuid) .build();
        deleteAccountPort.deleteAccount(deleteAccount);

    }

}
