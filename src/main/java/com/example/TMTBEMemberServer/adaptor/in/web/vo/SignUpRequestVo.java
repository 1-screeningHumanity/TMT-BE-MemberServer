package com.example.TMTBEMemberServer.adaptor.in.web.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestVo {
    private String name;
    private String password;
    private String phoneNumber;
    private String nickname;
}