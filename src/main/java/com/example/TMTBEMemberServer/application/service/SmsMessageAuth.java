package com.example.TMTBEMemberServer.application.service;


import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SmsMessageAuth {

    private final String PREFIX = "sms:"; // key값이 중복되지 않도록 상수 선언
    private final StringRedisTemplate stringRedisTemplate;

    public void createSmsCertification(String recivedPhoneNum, String verifyCode) {
        // 인증번호 유효 시간
        int LIMIT_TIME = 3 * 60;
        stringRedisTemplate.opsForValue()
                .set(PREFIX + recivedPhoneNum, verifyCode, Duration.ofSeconds(LIMIT_TIME));
    }

    // recived phoneNumber에 해당하는 인증번호 비교
    public String getSmsCertification(String recivedPhoneNum) {
        return stringRedisTemplate.opsForValue().get(PREFIX + recivedPhoneNum);
    }

    // 인증완료시 인증번호삭제
    public void deleteSmsCertification(String recivedPhoneNum) {
        stringRedisTemplate.delete(PREFIX + recivedPhoneNum);
    }

    // Redis에 해당 recivedPhoneNumber로 저장된 인증번호가 존재하는지 확인
    public boolean hasKey(String recivedPhoneNum) {
        return Boolean.TRUE.equals(stringRedisTemplate.hasKey(PREFIX + recivedPhoneNum));
    }



}
