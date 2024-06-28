package com.example.TMTBEMemberServer.application.port.in.usecase;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto.FeignClientNicknameResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface FeignClientUsecase {


    FeignClientNicknameResponseVo getNicknameUuid(UuidRequestDto uuidRequestDto);




    @Getter
    @NoArgsConstructor
    class UuidRequestDto{
        private String uuid;

        @Builder
        public UuidRequestDto(String uuid) {
            this.uuid = uuid;
        }

    }

}
