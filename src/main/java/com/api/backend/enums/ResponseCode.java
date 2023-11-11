package com.api.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    
    SUCCESS("2000", "성공"),
    
    FAIL("4000", "시스템 에러 발생"),
    ;
    
    private String code;
    private String msg;
}
