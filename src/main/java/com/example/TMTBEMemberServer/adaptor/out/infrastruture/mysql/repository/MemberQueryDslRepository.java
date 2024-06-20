package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto.NicknameKafkaProducerDto;
import com.example.TMTBEMemberServer.domain.NicknameChange;
import com.example.TMTBEMemberServer.global.common.enumclass.Grade;
import org.springframework.transaction.annotation.Transactional;

public interface MemberQueryDslRepository {
    void changeStatusLogin(Long memberId);

    void nicknameChange(NicknameKafkaProducerDto nicknameChange);

    void changeStatusLogout(String uuid);

    void changeStatusOut(String uuid);

    String myNickname(String uuid);

    Grade myGrade(String uuid);
}
