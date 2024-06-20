package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NicknameKafkaProducerDto {

    private String beforeNickName;
    private String afterNickName;

    @Builder
    public NicknameKafkaProducerDto(String beforeNickName, String afterNickName) {
        this.beforeNickName = beforeNickName;
        this.afterNickName = afterNickName;
    }

}
