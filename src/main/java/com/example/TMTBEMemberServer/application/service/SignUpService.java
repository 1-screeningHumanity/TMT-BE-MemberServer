package com.example.TMTBEMemberServer.application.service;


import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.MemberEntity;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance.SignUpAdaptor;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.SignUpJpaRepository;
import com.example.TMTBEMemberServer.application.port.in.usecase.SignUpUsecase;
import com.example.TMTBEMemberServer.application.port.out.dto.SignUpDto;
import com.example.TMTBEMemberServer.application.port.out.outport.SaveSignUpPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService implements SignUpUsecase {

    private final SaveSignUpPort saveSignUpPort;
    private final ModelMapper modelMapper;
////    private final SignUpAdaptor signUpAdaptor;
//    private final SaveSignUpPort saveSignUpPort;
    @Override
    public SignUpDto SignUp(SignUpRequiredDto signUpReqiuredDto) {
        SignUpDto signupDto = modelMapper.map(signUpReqiuredDto, SignUpDto.class);
        return saveSignUpPort.signUp(signupDto);
    }

}
