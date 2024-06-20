package com.example.TMTBEMemberServer.adaptor.in.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KafkaSendMessageDto {

    private String nickname;
    private String uuid;

}
