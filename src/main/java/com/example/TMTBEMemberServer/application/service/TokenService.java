//package com.example.TMTBEMemberServer.application.service;
//
//
//import com.example.TMTBEMemberServer.application.port.in.usecase.TokenUsecase;
//import com.example.TMTBEMemberServer.global.common.exception.CustomException;
//import com.example.TMTBEMemberServer.global.common.response.BaseResponseCode;
//import com.example.TMTBEMemberServer.global.common.token.DecodingToken;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class TokenService implements TokenUsecase {
//
//
//    private final DecodingToken decodingToken;
//
//
////    private final JWTUtil jwtUtil;
//
//    /**
//     * 1.Refresh Token 유효성 체크
//     * 2.저장소에 Refresh Token 존재유무 체크
//     * 3. 1, 2 모두 검증되면 재발급 진행
//     * 4. Response header에 새로 발급한 Access Token 저장
//     **/
//
//    @Override
//    public void reissueToken(String jwt){
//
//        String uuid = decodingToken.getUuid(jwt);
//
//        if(jwt == null){
//            throw new CustomException(BaseResponseCode.WRONG_TOKEN);
//        }
//
//
//    }
//
//}
