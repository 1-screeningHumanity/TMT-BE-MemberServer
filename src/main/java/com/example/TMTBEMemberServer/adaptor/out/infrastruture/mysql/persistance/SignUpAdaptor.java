package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.persistance;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.MemberEntity;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository.SignUpJpaRepository;
import com.example.TMTBEMemberServer.application.port.out.dto.SignUpDto;
import com.example.TMTBEMemberServer.application.port.out.outport.SaveSignUpPort;
import com.example.TMTBEMemberServer.global.common.exception.CustomException;
import com.example.TMTBEMemberServer.global.common.response.BaseResponseCode;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor

public class SignUpAdaptor implements SaveSignUpPort {

    private final SignUpJpaRepository signUpJpaRepository;
    private final ModelMapper modelMapper;


    @Transactional
    public SignUpDto signUp(SignUpDto signUpDto){
        if(signUpJpaRepository.findByNickname(signUpDto.getNickName())!=null){
            MemberEntity member = (modelMapper.map(signUpDto, MemberEntity.class));
            signUpJpaRepository.save(member);
        }
        throw new CustomException(BaseResponseCode.SIGNUP_FAILED);
    }

}
