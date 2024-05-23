package com.example.TMTBEMemberServer.application.service;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance.SignUpAdaptor;
import com.example.TMTBEMemberServer.application.port.in.usecase.SignUpUsecase;
import com.example.TMTBEMemberServer.application.port.out.dto.SignUpDto;
import com.example.TMTBEMemberServer.application.port.out.outport.SaveSignUpPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService implements SignUpUsecase {
;
    private final SignUpAdaptor signUpAdaptor;
    private final ModelMapper modelMapper;
    private final SaveSignUpPort saveSignUpPort;

    @Override
    public SignUpDto SignUp(SignUpRequiredDto signUpReqiuredDto) {
        SignUpDto signupDto = modelMapper.map(signUpReqiuredDto, SignUpDto.class);
        saveSignUpPort.signUp(signupDto);
        return signupDto;
    }

}
