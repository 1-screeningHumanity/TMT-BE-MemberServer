package com.example.TMTBEMemberServer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordChangeWithoutAuth {

    private String name;
    private String phoneNumber;
    private String password;
}
