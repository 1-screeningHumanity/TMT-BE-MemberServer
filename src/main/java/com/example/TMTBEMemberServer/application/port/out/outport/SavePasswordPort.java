package com.example.TMTBEMemberServer.application.port.out.outport;

import com.example.TMTBEMemberServer.domain.PasswordChange;
import com.example.TMTBEMemberServer.domain.PasswordChangeWithoutAuth;

public interface SavePasswordPort {

    void changePassword(PasswordChange passwordChange);

    void changePasswordWithout(PasswordChangeWithoutAuth passwordChangeWithoutAuth);

}
