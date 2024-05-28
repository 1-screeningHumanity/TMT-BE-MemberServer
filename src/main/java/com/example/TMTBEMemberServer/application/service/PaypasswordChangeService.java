package com.example.TMTBEMemberServer.application.service;

import com.example.TMTBEMemberServer.application.port.in.usecase.PayPasswordChangeUsecase;
import com.example.TMTBEMemberServer.application.port.out.outport.SavePayPasswordPort;
import com.example.TMTBEMemberServer.domain.PayPasswordChange;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
@RequiredArgsConstructor
public class PaypasswordChangeService implements PayPasswordChangeUsecase {

    private final SavePayPasswordPort savePayPasswordPort;
    private final ModelMapper modelMapper;

    public void changePaypassword(PaypasswordChangeRequestDto paypasswordChangeRequestDto,
            String uuid) {

        PayPasswordChange payPasswordChange = PayPasswordChange.builder()
                .uuid(uuid)
                .payingPassword(paypasswordChangeRequestDto.getPayingPassword())
                .build();

        savePayPasswordPort.updatePaypassword(payPasswordChange);

    }

}
