package com.example.TMTBEMemberServer.adaptor.in.web.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequestVo {

    private String name;
    private String password;
    private String phoneNumber;



}
