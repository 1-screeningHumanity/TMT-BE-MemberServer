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
    private String grade;

    @Builder
    public FeignClientNicknameResponseVo(String uuid, String nickname, String grade) {
        this.uuid = uuid;
        this.nickname = nickname;
        this.grade = grade;
    }
}
