package com.example.TMTBEMemberServer.adaptor.in.kafka.persistance;

import com.example.TMTBEMemberServer.adaptor.in.kafka.dto.KafkaSendMessageDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerAdaptor {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(KafkaSendMessageDto kafkaSendMessage) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInString = "";

        log.info("uuid ={}", kafkaSendMessage.getUuid());

        String topic = kafkaSendMessage.getTopic();
        log.info("topic ={}", topic);
        try {
            jsonInString = objectMapper.writeValueAsString(kafkaSendMessage.getUuid());
        } catch (Exception e) {
            e.printStackTrace();
        }

        kafkaTemplate.send(topic, jsonInString);
        log.info("send Message = {}", kafkaSendMessage.toString());

    }
}
