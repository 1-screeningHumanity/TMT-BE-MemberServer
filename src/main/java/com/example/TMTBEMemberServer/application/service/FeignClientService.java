package com.example.TMTBEMemberServer.application.service;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.dto.FeignClientNicknameResponseVo;
import com.example.TMTBEMemberServer.application.port.in.usecase.FeignClientUsecase;
import com.example.TMTBEMemberServer.application.port.out.dto.FeignClientNIcknameDto;
import com.example.TMTBEMemberServer.application.port.out.outport.LoadInfoport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FeignClientService implements FeignClientUsecase {

    private final LoadInfoport loadInfoport;
    private final ModelMapper modelMapper;

    @Override
    public FeignClientNicknameResponseVo getNicknameUuid(UuidRequestDto uuidRequestDto) {

        log.info("getuuid = {}", uuidRequestDto.getUuid());
        FeignClientNicknameResponseVo nicknameUuid =
                loadInfoport.getNicknameUuid(modelMapper.map(uuidRequestDto,
               FeignClientNIcknameDto.class));

        return nicknameUuid;
    }

}
