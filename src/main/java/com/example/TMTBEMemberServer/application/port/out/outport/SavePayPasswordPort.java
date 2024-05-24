package com.example.TMTBEMemberServer.application.port.out.outport;

import com.example.TMTBEMemberServer.domain.PayPassword;
import org.springframework.transaction.annotation.Transactional;

public interface SavePayPasswordPort {
    @Transactional
    void savePayPassword(PayPassword payPassword);
}
