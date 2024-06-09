package com.example.TMTBEMemberServer.application.service;

import com.example.TMTBEMemberServer.application.port.in.usecase.KafkaProducerUsecase;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto.KafkaProducerWalletDto;
import com.example.TMTBEMemberServer.application.port.out.outport.KafkaSendMessagePort;
import com.example.TMTBEMemberServer.domain.KafkaSendMessage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class KafkaService implements KafkaProducerUsecase {

    private final ModelMapper modelMapper;
    private final KafkaSendMessagePort kafkaSendMessagePort;

    @Override
    public void kafkaProducer(KafkaProducerWalletDto kafkaProducerWalletDto){
        kafkaSendMessagePort.sendMessage(modelMapper.map(kafkaProducerWalletDto, KafkaSendMessage.class));
    }

}
