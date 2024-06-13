package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository;

import com.example.TMTBEMemberServer.domain.NicknameChange;
import com.example.TMTBEMemberServer.global.common.enumclass.Grade;

public interface MemberQueryDslRepository {
    void changeStatusLogin(Long memberId);
    void nicknameChange(NicknameChange nicknameChange);
    void changeStatusLogout(String uuid);

    void changeStatusOut(String uuid);

    String myNickname(String uuid);

    Grade myGrade(String uuid);
}
