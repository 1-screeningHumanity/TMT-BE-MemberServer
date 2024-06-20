package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KafkaProducerWalletDto {

    private String  uuid;


    @Builder
    public KafkaProducerWalletDto(String uuid) {
        this.uuid = uuid;
    }

}
