package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.MemberEntity;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.MemberJpaRepository;
import com.example.TMTBEMemberServer.application.port.out.outport.SavePayPasswordPort;
import com.example.TMTBEMemberServer.domain.PayPassword;
import com.example.TMTBEMemberServer.domain.PayPasswordChange;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
@Slf4j
public class PayPasswordAdaptor implements SavePayPasswordPort {

    private final MemberJpaRepository memberJpaRepository;
    public String hashPassword(String Password) { //PW 해시 암호화
        Password = new BCryptPasswordEncoder().encode(Password);
        return Password;
    }
    @Override
    @Transactional //결제 패스워드 수정.
    public void savePayPassword(PayPassword payPassword) {
        log.info("nickname:{}", payPassword.getNickname());
        log.info("paypassword:{}", payPassword.getPayingPassword());

        Optional<MemberEntity> member = memberJpaRepository.findByNickname(payPassword.getNickname());

            MemberEntity insertPassword = MemberEntity.builder()
                    .memberId(member.get().getMemberId())
                    .name(member.get().getName())
                    .password(member.get().getPassword())
                    .nickname(member.get().getNickname())
                    .payingPassword(hashPassword(payPassword.getPayingPassword()))
                    .uuid(member.get().getUuid())
                    .status(member.get().getStatus())
                    .grade(member.get().getGrade())
                    .phoneNumber(member.get().getPhoneNumber())
                    .build();
            memberJpaRepository.save(insertPassword);

    }

    @Override
    @Transactional
    public void updatePaypassword(PayPasswordChange payPasswordChange){
        Optional<MemberEntity> member = memberJpaRepository.findByUuid(payPasswordChange.getUuid());
        MemberEntity changePaypassword = MemberEntity.builder()
                .memberId(member.get().getMemberId())
                .name(member.get().getName())
                .password(member.get().getPassword())
                .nickname(member.get().getNickname())
                .payingPassword(hashPassword(payPasswordChange.getPayingPassword()))
                .uuid(member.get().getUuid())
                .status(member.get().getStatus())
                .grade(member.get().getGrade())
                .phoneNumber(member.get().getPhoneNumber())
                .build();
        memberJpaRepository.save(changePaypassword);
    }
}
