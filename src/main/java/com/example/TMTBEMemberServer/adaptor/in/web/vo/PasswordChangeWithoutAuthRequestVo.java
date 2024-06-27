package com.example.TMTBEMemberServer.adaptor.in.web.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PasswordChangeWithoutAuthRequestVo {

    private String name;
    private String phoneNumber;
    private String password;
}
