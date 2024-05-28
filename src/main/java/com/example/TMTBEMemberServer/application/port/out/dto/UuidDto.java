package com.example.TMTBEMemberServer.application.port.out.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UuidDto {

    private Long memberId;
    private String uuid;

    @Builder
    public UuidDto(Long memberId, String uuid) {
        this.memberId = memberId;
        this.uuid = uuid;
    }
}
