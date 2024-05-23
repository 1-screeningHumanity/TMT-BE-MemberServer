package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUpJpaRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findByNickname(String nickname);

    boolean existsByNickname(String nickname); //닉네임 중복체크


}
