package com.api.backend.common;

import java.time.Instant;

import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CommonRes {    
    private int code;
    private String message;
    private long timestamp;

    @Nullable
    private Object payload;

    public CommonRes(int code, String message, Object payload) {
        this.code = code;
        this.message = message;
        this.payload = payload;
        this.timestamp = Instant.now().toEpochMilli();
    }

    public static CommonRes success() {
        return new CommonRes(CommonResCode.SUCCESS.getCode(), CommonResCode.SUCCESS.getMessage(), null);
    }

    public static CommonRes fail() {
        return new CommonRes(CommonResCode.FAIL.getCode(), CommonResCode.FAIL.getMessage(), null);
    }

    public static CommonRes withPayload(CommonResCode commonResCode, Object payload) {
        return new CommonRes(commonResCode.getCode(), commonResCode.getMessage(), payload);
    }
}