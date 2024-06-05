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

        String reAccessToken = checkAccessToken(withoutBearer,uuid);
        
        return ReAccessTokenDto.builder()
                .AccessToken(reAccessToken)
                .build();
    }

    public  String checkAccessToken(String RefreshToken, String uuid) {

        Boolean check = redisTemplate.hasKey(uuid);

        if (Boolean.TRUE.equals(check)) {
            
            //uuid를 key값으로 저장된 RefreshToken을 불러옴
            String storedRefreshToken = redisTemplate.opsForValue().get(uuid);

            if(!RefreshToken.equals(storedRefreshToken)) {
                
                throw new CustomException(BaseResponseCode.WRONG_TOKEN);
            }
            return jwtUtil.remakeAccessToken(uuid);
        }
        return new CustomException(BaseResponseCode.WRONG_TOKEN).getMessage();
    }
}

