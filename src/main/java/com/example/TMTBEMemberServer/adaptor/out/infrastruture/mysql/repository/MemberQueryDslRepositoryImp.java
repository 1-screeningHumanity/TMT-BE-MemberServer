package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository;

import static com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.QMemberEntity.memberEntity;

import com.example.TMTBEMemberServer.adaptor.in.kafka.persistance.KafkaProducerAdaptor;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto.NicknameKafkaProducerDto;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance.NicknameChangeAdaptor;
import com.example.TMTBEMemberServer.global.common.enumclass.Grade;
import com.example.TMTBEMemberServer.global.common.enumclass.State;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class MemberQueryDslRepositoryImp implements MemberQueryDslRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final KafkaProducerAdaptor kafkaProducerAdaptor;

    @Override
    @Transactional
    public void changeStatusLogin(Long memberId) {

        jpaQueryFactory
                .update(memberEntity)
                .set(memberEntity.status, State.SIGNIN)
                .where(memberEntity.memberId.eq(memberId))
                .execute();

    }

    @Override
    @Transactional
    public void nicknameChange(NicknameKafkaProducerDto nicknameChange){

        jpaQueryFactory
                .update(memberEntity)
                .set(memberEntity.nickname, nicknameChange.getAfterNickName())
                .where(memberEntity.nickname.eq(nicknameChange.getBeforeNickName()))
                .execute();

        kafkaProducerAdaptor.sendNicknameChangeMypage(nicknameChange);


    }

    @Override
    @Transactional
    public void changeStatusLogout(String uuid){

        jpaQueryFactory
                .update(memberEntity)
                .set(memberEntity.status, State.SIGNOUT)
                .where(memberEntity.uuid.eq(uuid))
                .execute();

    }

    @Override
    @Transactional
    public void changeStatusOut(String uuid){
        jpaQueryFactory
                .update(memberEntity)
                .set(memberEntity.status, State.OUT)
                .where(memberEntity.uuid.eq(uuid))
                .execute();
    }

    @Override
    public String myNickname(String uuid){
        return jpaQueryFactory
                .select(memberEntity.nickname)
                .from(memberEntity)
                .where(memberEntity.uuid.eq(uuid))
                .fetchOne();
    }

    @Override
    public Grade myGrade(String uuid){
        return jpaQueryFactory
                .select(memberEntity.grade)
                .from(memberEntity)
                .where(memberEntity.uuid.eq(uuid))
                .fetchOne();
    }

}
