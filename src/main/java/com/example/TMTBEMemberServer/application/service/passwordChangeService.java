package com.example.TMTBEMemberServer.application.service;


import com.example.TMTBEMemberServer.adaptor.in.web.vo.PasswordChangeWithoutAuthRequestVo;
import com.example.TMTBEMemberServer.application.port.in.usecase.PasswordChangeUsecase;
import com.example.TMTBEMemberServer.application.port.out.outport.SavePasswordPort;
import com.example.TMTBEMemberServer.domain.PasswordChange;
import com.example.TMTBEMemberServer.domain.PasswordChangeWithoutAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class passwordChangeService implements PasswordChangeUsecase {

    private final SavePasswordPort savePasswort ;

    public void passwordChange(passwordChangeRequestDto passwordChangeRequestDto, String uuid){

        PasswordChange passwordChange = PasswordChange
                .builder()
                .uuid(uuid)
                .password(passwordChangeRequestDto.getPassword())
                .build();
        savePasswort.changePassword(passwordChange);
    }

    @Override
    public void passwordChangeWithoutAuth(PasswordChangeWithoutAuthRequestVo requestVo) {
        savePasswort.changePasswordWithout(
                PasswordChangeWithoutAuth
                        .builder()
                        .name(requestVo.getName())
                        .password(requestVo.getPassword())
                        .phoneNumber(requestVo.getPhoneNumber())
                        .build()
        );
    }

}
