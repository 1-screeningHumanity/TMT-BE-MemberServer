package com.example.TMTBEMemberServer.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignIn {

    private String name;
    private String password;
    private String phoneNumber;

}
