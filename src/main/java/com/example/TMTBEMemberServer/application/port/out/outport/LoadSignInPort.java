package com.example.TMTBEMemberServer.application.port.out.outport;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.MemberEntity;
import com.example.TMTBEMemberServer.domain.SignIn;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

public interface LoadSignInPort {
    Optional<MemberEntity> signIn(SignIn signIn);
    void changeStatusLogIn(Long memberId);
}
