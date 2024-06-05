package com.example.TMTBEMemberServer.application.service;


import com.example.TMTBEMemberServer.application.port.in.usecase.TokenUsecase;
import com.example.TMTBEMemberServer.application.port.out.dto.ReAccessTokenDto;
import com.example.TMTBEMemberServer.global.common.exception.CustomException;
import com.example.TMTBEMemberServer.global.common.response.BaseResponseCode;
import com.example.TMTBEMemberServer.global.common.token.DecodingToken;
import com.example.TMTBEMemberServer.global.config.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenService implements TokenUsecase {


    private final DecodingToken decodingToken;
    private final RedisTemplate<String,String> redisTemplate;
    private final JWTUtil jwtUtil;

    @Override
    public ReAccessTokenDto reissueToken(String jwt) {

        String uuid = decodingToken.getUuid(jwt);
        String withoutBearer = jwt.substring(7);

        if (jwt == null) {
            throw new CustomException(BaseResponseCode.EMPTY_TOKEN);
        }
        log.info("2222222222222222222");

        String reAccessToken = checkAccessToken(withoutBearer,uuid);


        log.info("666666666666666666666");
        return ReAccessTokenDto.builder()
                .AccessToken(reAccessToken)
                .build();
    }

    public  String checkAccessToken(String RefreshToken, String uuid) {

        Boolean check = redisTemplate.hasKey(uuid);

        if (Boolean.TRUE.equals(check)) {


            log.info("333333333333");
            log.info("accesstoken{}",RefreshToken);
            //uuid를 key값으로 저장된 RefreshToken을 불러옴
            String storedRefreshToken = redisTemplate.opsForValue().get(uuid);
            log.info("redisRefresh{}",storedRefreshToken);

            if(!RefreshToken.equals(storedRefreshToken)) {

                log.info("444444444444444");
                throw new CustomException(BaseResponseCode.WRONG_TOKEN);
            }
            return jwtUtil.remakeAccessToken(uuid);
        }
        log.info("555555555555555");
        return new CustomException(BaseResponseCode.WRONG_TOKEN).getMessage();
    }
}

