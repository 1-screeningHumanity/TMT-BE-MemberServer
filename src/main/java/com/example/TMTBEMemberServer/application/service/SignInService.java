package com.example.TMTBEMemberServer.application.service;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.MemberEntity;
import com.example.TMTBEMemberServer.application.port.out.dto.SignInResponseDto;
import com.example.TMTBEMemberServer.application.port.in.usecase.SignInUsecase;
import com.example.TMTBEMemberServer.application.port.out.outport.LoadSignInPort;
import com.example.TMTBEMemberServer.domain.SignIn;
import com.example.TMTBEMemberServer.global.common.exception.CustomException;
import com.example.TMTBEMemberServer.global.common.response.BaseResponseCode;
import com.example.TMTBEMemberServer.global.config.JWTUtil;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class SignInService implements SignInUsecase {

    private final ModelMapper modelMapper;
    private final LoadSignInPort loadSignInPort;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public SignInResponseDto SigninService(SigninRequestDto signinRequestDto){
        SignIn signIn = modelMapper.map(signinRequestDto, SignIn.class);
        Optional<MemberEntity> optionalMember = loadSignInPort.signIn(signIn);

        if(optionalMember.isPresent()) {
            MemberEntity member = optionalMember.get();
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            member.getUuid(),
                            signIn.getPassword()
                    )
            );

            String accessToken = jwtUtil.createAccessToken(authentication); // 사용자 Access 토큰 생성
            String refreshToken = jwtUtil.createRefreshToken(authentication); // 사용자 Refresh 토큰 생성

            loadSignInPort.changeStatusLogIn(member.getMemberId());

            return SignInResponseDto.builder()
                    .name(member.getName())
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .build();

        } else {
            throw new CustomException(BaseResponseCode.SIGNIN_FAILED);

        }
    }
}