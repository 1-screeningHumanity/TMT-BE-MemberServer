package com.example.TMTBEMemberServer.application.service;

import com.example.TMTBEMemberServer.application.port.in.usecase.SignOutUsecase;
import com.example.TMTBEMemberServer.application.port.out.outport.LoadSignoutPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SignOutService implements SignOutUsecase {

    private final RedisTemplate redisTemplate;
    private final LoadSignoutPort loadSignoutPort;


    public void signOut(String uuid){
        redisTemplate.delete(uuid);
        loadSignoutPort.statusLogout(uuid);

    }

}
