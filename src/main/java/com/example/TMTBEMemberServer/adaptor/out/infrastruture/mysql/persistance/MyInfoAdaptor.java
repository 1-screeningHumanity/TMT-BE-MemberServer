package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.MemberQueryDslRepository;
import com.example.TMTBEMemberServer.application.port.out.outport.LoadMyInfoport;
import com.example.TMTBEMemberServer.global.common.enumclass.Grade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyInfoAdaptor implements LoadMyInfoport {

    private final MemberQueryDslRepository memberQueryDslRepository;


    @Override
    public String myNickname(String uuid){
        String nickname = memberQueryDslRepository.myNickname(uuid);
        return nickname;

    }

    @Override
    public String myGrade(String uuid){
        Grade grade = memberQueryDslRepository.myGrade(uuid);
        String mygrade = grade.name();
        return mygrade;
    }
}
