package com.example.TMTBEMemberServer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NicknameChange {

    private String nickname;
    private String uuid;

}
