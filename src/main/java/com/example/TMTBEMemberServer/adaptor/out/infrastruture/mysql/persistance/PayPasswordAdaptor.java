package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.MemberEntity;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.SignUpJpaRepository;
import com.example.TMTBEMemberServer.application.port.out.outport.SavePayPasswordPort;
import com.example.TMTBEMemberServer.domain.PayPassword;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
@Slf4j
public class PayPasswordAdaptor implements SavePayPasswordPort {

    private final SignUpJpaRepository signUpJpaRepository;
    public String hashPassword(String Password) { //PW 해시 암호화
        Password = new BCryptPasswordEncoder().encode(Password);
        return Password;
    }
    @Override
    @Transactional //결제 패스워드 수정.
    public void savePayPassword(PayPassword payPassword) {
        MemberEntity member = signUpJpaRepository.findByNickname(payPassword.getNickname());
        MemberEntity updatePaypassword = MemberEntity.builder()
                .memberId(member.getMemberId())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .payingPassword(hashPassword(payPassword.getPayingPassword()))
                .uuid(member.getUuid())
                .status(member.getStatus())
                .grade(member.getGrade())
                .phoneNumber(member.getPhoneNumber())
                .build();
        signUpJpaRepository.save(updatePaypassword);
    }
}
