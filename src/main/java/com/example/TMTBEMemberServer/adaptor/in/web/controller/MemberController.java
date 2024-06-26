package com.example.TMTBEMemberServer.adaptor.in.web.controller;

import com.example.TMTBEMemberServer.adaptor.in.web.vo.NicknameChangeRequestVo;
import com.example.TMTBEMemberServer.adaptor.in.web.vo.PasswordChangeRequestVo;
import com.example.TMTBEMemberServer.adaptor.in.web.vo.PayPasswordRequestVo;
import com.example.TMTBEMemberServer.adaptor.in.web.vo.PaypasswordChangeRequestVo;
import com.example.TMTBEMemberServer.adaptor.in.web.vo.PaypasswordCheckRequestvo;
import com.example.TMTBEMemberServer.adaptor.in.web.vo.SignInRequestVo;
import com.example.TMTBEMemberServer.adaptor.in.web.vo.SignUpRequestVo;
import com.example.TMTBEMemberServer.application.port.in.usecase.DeleteAccountUsecase;
import com.example.TMTBEMemberServer.application.port.in.usecase.NickNameChangeUsecase;
import com.example.TMTBEMemberServer.application.port.in.usecase.PasswordChangeUsecase;
import com.example.TMTBEMemberServer.application.port.in.usecase.PayPasswordChangeUsecase;
import com.example.TMTBEMemberServer.application.port.in.usecase.SignOutUsecase;
import com.example.TMTBEMemberServer.application.port.in.usecase.TokenUsecase;
import com.example.TMTBEMemberServer.application.port.out.dto.ReAccessTokenDto;
import com.example.TMTBEMemberServer.application.port.out.dto.SignInResponseDto;
import com.example.TMTBEMemberServer.application.port.in.usecase.PayPasswordUsecase;
import com.example.TMTBEMemberServer.application.port.in.usecase.RandomNicknameUsecase;
import com.example.TMTBEMemberServer.application.port.in.usecase.SignInUsecase;
import com.example.TMTBEMemberServer.application.port.in.usecase.SignUpUsecase;
import com.example.TMTBEMemberServer.application.port.out.dto.RandomNicknameDto;
import com.example.TMTBEMemberServer.global.common.response.BaseResponse;
import com.example.TMTBEMemberServer.global.common.token.DecodingToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
public class MemberController {

    private final ModelMapper modelMapper;
    private final SignUpUsecase signUpUsecase;
    private final RandomNicknameUsecase randomNicknameUsecase;
    private final PayPasswordUsecase payPasswordUsecase;
    private final SignInUsecase signInUsecase;
    private final DecodingToken decodingToken;
    private final NickNameChangeUsecase nickNameChangeUsecase;
    private final PayPasswordChangeUsecase payPasswordChangeUsecase;
    private final SignOutUsecase signOutUsecase;
    private final PasswordChangeUsecase passwordChangeUsecase;
    private final DeleteAccountUsecase deleteAccountUsecase;
    private final TokenUsecase tokenUsecase;

    @PostMapping("/signup") //회원가입
    public BaseResponse<Void> SignUp(@RequestBody SignUpRequestVo signUpRequestVo) {

        signUpUsecase.SignUp(modelMapper.map(signUpRequestVo, SignUpUsecase.SignUpRequiredDto.class));
        return new BaseResponse<>();

    }

    @GetMapping("/random-nickname") //랜덤 닉네임생성
    public BaseResponse<String> randomNickName() {

        RandomNicknameDto randomNicknameDto = randomNicknameUsecase.createRamdomNickName();
        String result = randomNicknameDto.getNickname();
        return new BaseResponse<>(result);


    }

    @PostMapping("/pay-password")//결제 비밀번호 설정
    public BaseResponse<Void> payPassword(@RequestBody PayPasswordRequestVo payPasswordRequestVo) {
        payPasswordUsecase.payPasswordUpdate(modelMapper.map(payPasswordRequestVo,
                PayPasswordUsecase.payPasswordRequestDto.class));
        return new BaseResponse<>();

    }

    @PostMapping("/signin") //로그인
    public BaseResponse<SignInResponseDto> signin(@RequestBody SignInRequestVo signInRequestVo) {

        SignInResponseDto SigninResponseDto = signInUsecase.SigninService(modelMapper.map(signInRequestVo,
                SignInUsecase.SigninRequestDto.class));
        return new BaseResponse<>(SigninResponseDto);

    }

    @PostMapping("/nickname") //닉네임 변경
    public BaseResponse<Void> nicknameChange(@RequestHeader ("Authorization") String jwt,
            @RequestBody NicknameChangeRequestVo
            nicknameChangeRequestVo) {

        String uuid = decodingToken.getUuid(jwt);

        nickNameChangeUsecase.nicknameChange(modelMapper.map(nicknameChangeRequestVo,
                NickNameChangeUsecase.nicknameChangeRequestDto.class),uuid);

        return new BaseResponse<>();
    }

    @PatchMapping("/pay-password") //결제비밀번호 재설정
    public BaseResponse<Void> payPasswordChange(@RequestHeader ("Authorization") String jwt,
            @RequestBody PaypasswordChangeRequestVo paypasswordChangeRequestVo) {

        String uuid = decodingToken.getUuid(jwt);
        payPasswordChangeUsecase.changePaypassword(modelMapper.map(paypasswordChangeRequestVo,
                PayPasswordChangeUsecase.PaypasswordChangeRequestDto.class),uuid);

        return new BaseResponse<>();
    }
    @PatchMapping("/password")// 비밀번호 변경
    public BaseResponse<Void> passwordChange(@RequestHeader ("Authorization") String jwt,
            @RequestBody PasswordChangeRequestVo passwordChangeRequestVo){
        String uuid = decodingToken.getUuid(jwt);
        passwordChangeUsecase.passwordChange(modelMapper.map(passwordChangeRequestVo,
                PasswordChangeUsecase.passwordChangeRequestDto.class),uuid);
        return new BaseResponse<>();
    }

    @PostMapping("/signout")//로그아웃
    public BaseResponse<Void> signOut(@RequestHeader ("Authorization") String jwt){
        String uuid = decodingToken.getUuid(jwt);
        signOutUsecase.signOut(uuid);
        return new BaseResponse<>();
    }

    @DeleteMapping("/") //회원탈퇴
    public BaseResponse<Void> deleteAccount(@RequestHeader ("Authorization") String jwt){
        String uuid = decodingToken.getUuid(jwt);
        deleteAccountUsecase.deleteAccountService(uuid);
        return new BaseResponse<>();

    }

    @PostMapping("/reissue") //Access Token 재생성
    public BaseResponse<ReAccessTokenDto> tokenExpired(@RequestHeader ("Authorization") String jwt){

        ReAccessTokenDto reAccessToken = tokenUsecase.reissueToken(jwt);
        return new BaseResponse<>(reAccessToken);

    }

    @PostMapping("/pay-password/check")
    public BaseResponse<Void> checkPayPassword(@RequestHeader ("Authorization") String jwt,
            @RequestBody PaypasswordCheckRequestvo paypasswordCheckRequestvo){

        String uuid = decodingToken.getUuid(jwt);

        payPasswordUsecase.payPasswordCheck(modelMapper.map(paypasswordCheckRequestvo,
                PayPasswordUsecase.payPasswordCheckRequestDto.class),uuid);


        return new BaseResponse<>();

    }
  
}
