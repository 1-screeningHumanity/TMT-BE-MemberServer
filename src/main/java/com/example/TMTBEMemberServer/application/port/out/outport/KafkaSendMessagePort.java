package com.example.TMTBEMemberServer.application.port.out.outport;

import com.example.TMTBEMemberServer.domain.KafkaSendMessage;

public interface KafkaSendMessagePort {

    void sendMessage(KafkaSendMessage kafkaSendMessage);
}
