package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.MemberEntity;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.MemberJpaRepository;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.MemberQueryDslRepository;
import com.example.TMTBEMemberServer.application.port.out.dto.UuidDto;
import com.example.TMTBEMemberServer.application.port.out.outport.LoadSignInPort;
import com.example.TMTBEMemberServer.domain.SignIn;
import com.example.TMTBEMemberServer.global.common.exception.CustomException;
import com.example.TMTBEMemberServer.global.common.response.BaseResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
@Slf4j
public class SignInAdaptor implements LoadSignInPort {
    private final MemberJpaRepository memberJpaRepository;
    private final MemberQueryDslRepository memberQueryDslRepository;
    @Override
    @Transactional
    public UuidDto signIn(SignIn signIn){

        MemberEntity member = memberJpaRepository.findByNameAndPhoneNumber(signIn.getName(),
                signIn.getPhoneNumber());
        if (member == null){
            throw new CustomException(BaseResponseCode.WRONG_NAME_PHONE_NUMBER);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); //PW 암호화 시킴
        if (!(encoder.matches(signIn.getPassword(), member.getPassword()))) {
            throw new CustomException(BaseResponseCode.WRONG_PASSWORD); //PW 가 다르면 로그인 실패
        }

        return UuidDto
                .builder()
                .memberId(member.getMemberId())
                .uuid(member.getUuid())
                .build();

    }
    @Override
    @Transactional
    public void changeStatusLogIn(Long memberId) {
        memberQueryDslRepository.changeStatusLogin(memberId);

    }

}
