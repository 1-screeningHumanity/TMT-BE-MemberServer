package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KafkaProducerWalletDto {

    private String  uuid;
    private String topic;

    @Builder
    public KafkaProducerWalletDto(String uuid, String topic) {
        this.uuid = uuid;
        this.topic = topic;
    }

}
