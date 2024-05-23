package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.MemberEntity;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.SignUpJpaRepository;
import com.example.TMTBEMemberServer.application.port.out.dto.SignUpDto;
import com.example.TMTBEMemberServer.application.port.out.outport.SaveSignUpPort;
import com.example.TMTBEMemberServer.global.common.exception.CustomException;
import com.example.TMTBEMemberServer.global.common.response.BaseResponseCode;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor

public class SignUpAdaptor implements SaveSignUpPort {

    private final SignUpJpaRepository signUpJpaRepository;
    public String hashPassword(String Password) { //PW 해시 암호화
        Password = new BCryptPasswordEncoder().encode(Password);
        return Password;
    }
    @Transactional
    @Override
    public void signUp(SignUpDto signUpDto){

        UUID uuid =UUID.randomUUID(); //uuid 생성
        String uuidString = uuid.toString();

        if(signUpJpaRepository.existsByNickname(signUpDto.getNickName())){ //닉네임 중복검사
            throw new CustomException(BaseResponseCode.SIGNUP_FAILED);
        }MemberEntity member = MemberEntity.builder()
                .name(signUpDto.getName())
                .phoneNumber(signUpDto.getPhoneNumber())
                .nickname(signUpDto.getNickName())
                .status("1")
                .password(hashPassword(signUpDto.getPassword()))
                .uuid(uuidString)
                .build();
            signUpJpaRepository.save(member);
    }
}
