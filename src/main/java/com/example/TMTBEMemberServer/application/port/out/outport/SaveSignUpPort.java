package com.example.TMTBEMemberServer.application.port.out.outport;


import com.example.TMTBEMemberServer.application.port.out.dto.SignUpDto;

public interface SaveSignUpPort {
    SignUpDto signUp(SignUpDto signUpDto);

}
