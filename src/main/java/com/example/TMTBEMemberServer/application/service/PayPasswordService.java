package com.example.TMTBEMemberServer.application.service;

import com.example.TMTBEMemberServer.application.port.in.usecase.PayPasswordUsecase;
import com.example.TMTBEMemberServer.application.port.out.outport.SavePayPasswordPort;
import com.example.TMTBEMemberServer.domain.PayPassword;
import com.example.TMTBEMemberServer.domain.PayPasswordCheck;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PayPasswordService implements PayPasswordUsecase {

    private final SavePayPasswordPort payPasswordPort;
    private final ModelMapper modelMapper;
    public  void payPasswordUpdate(payPasswordRequestDto payPasswordRequestDto){
        payPasswordPort.savePayPassword(modelMapper.map(payPasswordRequestDto, PayPassword.class));
    }

    public  void payPasswordCheck(payPasswordCheckRequestDto payPasswordCheckRequestDto,
            String uuid){
        payPasswordPort.checkPayPassword(modelMapper.map(payPasswordCheckRequestDto,
                PayPasswordCheck.class),uuid);
    }

}
