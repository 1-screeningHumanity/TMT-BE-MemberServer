package com.example.TMTBEMemberServer.application.port.out.outport;

import com.example.TMTBEMemberServer.domain.PasswordChange;

public interface SavePasswordPort {

    void changePassword(PasswordChange passwordChange);

}
