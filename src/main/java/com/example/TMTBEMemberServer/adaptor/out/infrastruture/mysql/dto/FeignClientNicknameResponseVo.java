package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeignClientNicknameResponseVo {

    private String uuid;
    private String nickname;

    @Builder
    public FeignClientNicknameResponseVo(String uuid, String nickname) {
        this.uuid = uuid;
        this.nickname = nickname;
    }
}
