package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity;

import com.example.TMTBEMemberServer.domain.SignUp;
import com.example.TMTBEMemberServer.global.common.response.State;
import com.example.TMTBEMemberServer.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
public class MemberEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId; //PK

    private String name; //이름

    private String password; //비밀번호

    private String nickname; //닉네임

    @Column(length = 4)
    private String payingPassword; //결제 PW

    private String uuid; //uuid

    private int status; //회원상태

    private String phoneNumber; //전화번호

    public static MemberEntity toEntity(SignUp signUp) {

        return MemberEntity.builder()
                .name(signUp.getName())
                .password(signUp.getPassword())
                .phoneNumber(signUp.getPhoneNumber())
                .nickname(signUp.getNickName())
                .build();
    }

}
