package com.example.TMTBEMemberServer.global.common.exception;

import com.example.TMTBEMemberServer.global.common.response.BaseResponseCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private final BaseResponseCode status;

    public CustomException(BaseResponseCode status) {
        this.status = status;
    }
}