package com.example.TMTBEMemberServer.application.port.out.outport;

import com.example.TMTBEMemberServer.domain.PayPassword;
import com.example.TMTBEMemberServer.domain.PayPasswordChange;

public interface SavePayPasswordPort {

    void savePayPassword(PayPassword payPassword);

    void updatePaypassword(PayPasswordChange payPasswordChange);


}
