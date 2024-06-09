package com.example.TMTBEMemberServer.adaptor.out.kafkaproducer.persistence;

import com.example.TMTBEMemberServer.adaptor.out.kafkaproducer.out.KafkaProducerOutDto;
import com.example.TMTBEMemberServer.application.port.out.outport.KafkaSendMessagePort;
import com.example.TMTBEMemberServer.domain.KafkaSendMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerAdaptor implements KafkaSendMessagePort {


    private final KafkaTemplate<String, String> kafkaTemplate;



    @Override
    public void sendMessage(KafkaSendMessage kafkaSendMessage) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInString = "";

        KafkaProducerOutDto kafkaProducerOutDto = KafkaProducerOutDto
                .builder()
                .uuid(kafkaSendMessage.getUuid())
                .build();

        String topic = kafkaSendMessage.getTopic();

        try {
            jsonInString = objectMapper.writeValueAsString(kafkaProducerOutDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        kafkaTemplate.send(topic, jsonInString);
        log.info("send Message = {}", kafkaProducerOutDto.toString());

    }
}
