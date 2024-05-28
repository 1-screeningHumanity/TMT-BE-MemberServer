package com.example.TMTBEMemberServer.application.port.out.outport;

import com.example.TMTBEMemberServer.domain.NicknameChange;
import org.springframework.transaction.annotation.Transactional;

public interface SaveNicknameChangePort {
    void saveNicknameChange(NicknameChange nicknameChange);
}
