package com.example.TMTBEMemberServer.application.port.in.usecase;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto.KafkaProducerWalletDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface KafkaProducerUsecase {


    void kafkaProducer(KafkaProducerWalletDto kafkaProducerWalletDto);

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class nicknameChangeRequestDto{
        private String uuid;
        private String topicname;

    }

}
