package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.SignUpJpaRepository;
import com.example.TMTBEMemberServer.application.port.out.outport.LoadRandomNicknamePort;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class RandomNicknameAdaptor implements LoadRandomNicknamePort {

    private final SignUpJpaRepository signUpJpaRepository;
    private final Random random = new Random(); //랜덤메소드 선언
    private static final String[] ADJECTIVES = {
            "섬세한", "용감한", "밝은", "신비로운", "따뜻한", "활발한", "차분한", "신중한", "행운의"
    };
    private static final String[] NOUNS = {
            "바다게", "별똥별", "달빛", "봄비", "달팽이", "초콜릿", "섬광", "무지개", "달빛"
    };

    @Override
    @Transactional
    public String loadRandomNickname() {

        String adjective = ADJECTIVES[random.nextInt(ADJECTIVES.length)]; //형용사 조합
        String noun = NOUNS[random.nextInt(NOUNS.length)]; //명사조합

        String nickname = adjective + noun;
        while (signUpJpaRepository.existsByNickname(nickname)) { //닉네임 중복검사
            adjective = ADJECTIVES[random.nextInt(ADJECTIVES.length)]; //형용사 조합
            noun = NOUNS[random.nextInt(NOUNS.length)]; //명사조합
            nickname = adjective + noun;
        }
        return nickname;
    }
}
