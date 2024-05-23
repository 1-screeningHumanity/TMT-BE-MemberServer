package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.MemberEntity;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.SignUpJpaRepository;
import com.example.TMTBEMemberServer.application.port.out.dto.SignUpDto;
import com.example.TMTBEMemberServer.application.port.out.outport.SaveSignUpPort;
import com.example.TMTBEMemberServer.global.common.exception.CustomException;
import com.example.TMTBEMemberServer.global.common.response.BaseResponseCode;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor

public class SignUpAdaptor implements SaveSignUpPort {

    private final SignUpJpaRepository signUpJpaRepository;
    private final ModelMapper modelMapper;

    public String hashPassword(String Password) { //PW 해시 암호화
        Password = new BCryptPasswordEncoder().encode(Password);
        return Password;
    }
    private final Random random = new Random(); //랜덤메소드 선언
    private final Set<String> nicknames = new HashSet<>(); //닉네임 자동생성
    private static final String[] ADJECTIVES = {
            "섬세한", "용감한", "밝은", "신비로운", "따뜻한", "활발한", "차분한", "신중한", "행운의"
    };
    private static final String[] NOUNS = {
            "바다게", "별똥별", "달빛", "봄비", "달팽이", "초콜릿", "섬광", "무지개", "달빛"
    };
    public String generateUniqueNickname() { //랜덤 닉네임 중복검사 메소드
        String nickname;
        do {
            nickname = randomNickname();
        } while (signUpJpaRepository.existsByNickname(nickname));
        return nickname;
    }

    private String randomNickname() { //랜덤 닉네임 생성 메소드
        String adjective = ADJECTIVES[random.nextInt(ADJECTIVES.length)]; //형용사 조합
        String noun = NOUNS[random.nextInt(NOUNS.length)]; //명사조합
        return adjective + noun;
    }

    @Transactional
    public SignUpDto signUp(SignUpDto signUpDto){

        UUID uuid =UUID.randomUUID(); //uuid 생성
        String uuidString = uuid.toString();

        if(signUpJpaRepository.existsByNickname(signUpDto.getNickName())){ //닉네임 중복검사
            throw new CustomException(BaseResponseCode.SIGNUP_FAILED);
        }else {MemberEntity member = MemberEntity.builder()
                .name(signUpDto.getName())
                .phoneNumber(signUpDto.getPhoneNumber())
                .nickname(signUpDto.getNickName())
                .status("1")
                .password(hashPassword(signUpDto.getPassword()))
                .uuid(uuidString)
                .build();
            signUpJpaRepository.save(member);
        }
        return null;
    }
}
