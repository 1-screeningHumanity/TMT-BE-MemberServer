package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;


import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.MemberEntity;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.MemberJpaRepository;
import com.example.TMTBEMemberServer.application.port.out.outport.SavePasswordPort;
import com.example.TMTBEMemberServer.domain.PasswordChange;
import com.example.TMTBEMemberServer.domain.PasswordChangeWithoutAuth;
import com.example.TMTBEMemberServer.global.common.exception.CustomException;
import com.example.TMTBEMemberServer.global.common.response.BaseResponseCode;
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
                .payingPassword(member.get().getPayingPassword())
                .phoneNumber(member.get().getPhoneNumber())
                .build());
    }

    @Override
    public void changePasswordWithout(PasswordChangeWithoutAuth input) {
        MemberEntity findData = memberJpaRepository.findAllByNameAndPhoneNumber(input.getName(),
                        input.getPhoneNumber())
                .orElseThrow(() -> new CustomException(
                        BaseResponseCode.PASSWORD_CHANGE_WITHOUT_AUTH_ERROR));

        memberJpaRepository.save(
                MemberEntity
                        .builder()
                        .memberId(findData.getMemberId())
                        .name(findData.getName())
                        .password(hashPassword(findData.getPassword()))
                        .nickname(findData.getNickname())
                        .payingPassword(findData.getPayingPassword())
                        .uuid(findData.getUuid())
                        .status(findData.getStatus())
                        .grade(findData.getGrade())
                        .phoneNumber(findData.getPhoneNumber())
                        .build());
    }


}
