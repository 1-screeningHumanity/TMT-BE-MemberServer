package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GradeinfoResponseDto {

    private String grade;

    @Builder
    public GradeinfoResponseDto(String grade) {
        this.grade = grade;
    }

}
