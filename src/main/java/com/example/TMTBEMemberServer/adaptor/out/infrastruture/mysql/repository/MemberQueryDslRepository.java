package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository;

import com.example.TMTBEMemberServer.domain.NicknameChange;

public interface MemberQueryDslRepository {
    void changeStatusLogin(Long memberId);
    void nicknameChange(NicknameChange nicknameChange);
    void changeStatusLogout(String uuid);
}
