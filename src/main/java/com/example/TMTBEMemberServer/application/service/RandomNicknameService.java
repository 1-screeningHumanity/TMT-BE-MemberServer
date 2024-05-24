package com.example.TMTBEMemberServer.application.service;

import com.example.TMTBEMemberServer.application.port.in.usecase.RandomNicknameUsecase;
import com.example.TMTBEMemberServer.application.port.out.dto.RandomNicknameDto;
import com.example.TMTBEMemberServer.application.port.out.outport.LoadRandomNicknamePort;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RandomNicknameService implements RandomNicknameUsecase {

    private final LoadRandomNicknamePort loadRandomNicknamePort;
    private final Random random = new Random(); //랜덤메소드 선언
    private static final String[] ADJECTIVES = {
            "섬세한", "용감한", "밝은", "신비로운", "따뜻한", "활발한", "차분한", "신중한", "행운의", "열정의",
            "가득한","배부른","배고픈","힘든","산뜻한","어려운","쉬운","똑똑한","진지한","열정적인","이쁜",
            "잘생긴","영롱한","거룩한","거대한","웅장한","빛나는","새로운","신박한","직관적인","직설적인"
    };
    private static final String[] NOUNS = {
            "바다게", "별똥별", "달빛", "봄비", "달팽이", "초콜릿", "섬광", "무지개", "달빛","코끼리","라면",
            "폭풍우","노래방","사자","호랑이","싼타페","맥북","살쾡이","삵","칡","흙","안경","책","커피",
            "신바람","천둥","칠판","다꽝","거치대","식탁","침대","마우스","잡지","모니터","핸드폰","햇빛"
    };

    public RandomNicknameDto createRamdomNickName(){


        String adjective = ADJECTIVES[random.nextInt(ADJECTIVES.length)]; //형용사 조합
        String noun = NOUNS[random.nextInt(NOUNS.length)]; //명사조합
        String nickname = adjective + noun;
        RandomNicknameDto randomNicknameDto = RandomNicknameDto.builder()
                .nickname(nickname)
                .build();

        //랜덤 닉네임 생성 완료 하고 dto 로 변환.
        Boolean tossnickname = loadRandomNicknamePort.loadRandomNickname(randomNicknameDto);

        if (tossnickname){
            randomnicknameFalse(true);
        }
        return randomNicknameDto;
    }

    public void randomnicknameFalse(Boolean result){

        if(result){
            createRamdomNickName();
        }

    }
}
