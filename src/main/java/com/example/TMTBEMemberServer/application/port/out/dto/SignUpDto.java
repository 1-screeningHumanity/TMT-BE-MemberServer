package com.example.TMTBEMemberServer.application.port.out.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class SignUpDto {

    private String name;
    private String password;
    private String phoneNumber;
    private String nickName;


}
