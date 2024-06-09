package com.example.TMTBEMemberServer.adaptor.out.kafkaproducer.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KafkaProducerOutDto {

    private String uuid;

    @Builder
    public KafkaProducerOutDto(String uuid) {
        this.uuid = uuid;
    }

}
