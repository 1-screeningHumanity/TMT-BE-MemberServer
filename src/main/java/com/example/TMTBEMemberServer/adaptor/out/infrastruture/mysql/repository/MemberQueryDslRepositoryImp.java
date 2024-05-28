package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository;

import static com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.QMemberEntity.memberEntity;

import com.example.TMTBEMemberServer.domain.NicknameChange;
import com.example.TMTBEMemberServer.global.common.response.State;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberQueryDslRepositoryImp implements MemberQueryDslRepository {

    private final JPAQueryFactory jpaQueryFactory;
    public void changeStatusLogin(Long memberId) {

        jpaQueryFactory
                .update(memberEntity)
                .set(memberEntity.status, State.SIGNIN)
                .where(memberEntity.memberId.eq(memberId))
                .execute();
    }

    public void nicknameChange(NicknameChange nicknameChange){

        jpaQueryFactory
                .update(memberEntity)
                .set(memberEntity.nickname, nicknameChange.getNickname())
                .where(memberEntity.uuid.eq(nicknameChange.getUuid()))
                .execute();

    }
    public void changeStatusLogout(String uuid){

        jpaQueryFactory
                .update(memberEntity)
                .set(memberEntity.status, State.SIGNOUT)
                .where(memberEntity.uuid.eq(uuid))
                .execute();

    }
    public void changeStatusOut(String uuid){
        jpaQueryFactory
                .update(memberEntity)
                .set(memberEntity.status, State.OUT)
                .where(memberEntity.uuid.eq(uuid))
                .execute();
    }
}
