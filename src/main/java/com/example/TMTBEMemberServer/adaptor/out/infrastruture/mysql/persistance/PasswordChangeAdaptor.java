package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;


import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.MemberEntity;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.MemberJpaRepository;
import com.example.TMTBEMemberServer.application.port.out.outport.SavePasswordPort;
import com.example.TMTBEMemberServer.domain.PasswordChange;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordChangeAdaptor implements SavePasswordPort {

    private final MemberJpaRepository memberJpaRepository;
    public String hashPassword(String Password) { //PW 해시 암호화
        Password = new BCryptPasswordEncoder().encode(Password);
        return Password;
    }
    public void changePassword(PasswordChange passwordChange){
        Optional<MemberEntity> member = memberJpaRepository.findByUuid(passwordChange.getUuid());
        memberJpaRepository.save(MemberEntity.builder()
                .name(member.get().getName())
                .memberId(member.get().getMemberId())
                .password(hashPassword(passwordChange.getPassword()))
                .nickname(member.get().getNickname())
                .uuid(member.get().getUuid())
                .status(member.get().getStatus())
                .grade(member.get().getGrade())
                .phoneNumber(member.get().getPhoneNumber())
                .build());
    }


}
