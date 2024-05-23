package com.example.TMTBEMemberServer.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUp {
    private String name;
    private String password;
    private String phoneNumber;
    private String nickName;

}
