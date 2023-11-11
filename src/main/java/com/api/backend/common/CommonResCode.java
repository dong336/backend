package com.api.backend.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonResCode {

    SUCCESS(2000, "성공"),
    FAIL(4000, "시스템 에러 발생"),

    FAIL_TEST(9999, "테스트"),
    ;
    // 응답 코드 추가...

    private final int code;
    private final String message;
}