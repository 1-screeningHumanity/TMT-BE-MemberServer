package com.example.TMTBEMemberServer.adaptor.in.kafka.persistance;

import com.example.TMTBEMemberServer.adaptor.in.kafka.dto.KafkaSendMessageDto;
import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto.NicknameKafkaProducerDto;
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


        String topic = "member-payment-signup";

        log.info("topic ={}", topic);
        try {
            jsonInString = objectMapper.writeValueAsString(kafkaSendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        kafkaTemplate.send(topic, jsonInString);
//        log.info("send Message = {}", kafkaSendMessage.toString());
        log.info("send Message = {}", jsonInString);

    }

    public void sendNicknameChangeMypage(NicknameKafkaProducerDto nIcknameKafkaProducerDto){

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInString = "";
        try {
            jsonInString = objectMapper.writeValueAsString(nIcknameKafkaProducerDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        kafkaTemplate.send("member-subscribe-changenickname", jsonInString);

    }

}
