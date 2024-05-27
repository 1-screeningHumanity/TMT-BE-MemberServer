package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository;

import static com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.QMemberEntity.memberEntity;

import com.example.TMTBEMemberServer.domain.NicknameChange;
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
                .set(memberEntity.status, 2)
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
}
