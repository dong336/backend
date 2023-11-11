package com.api.backend.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {
    
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<CommonRes> handleRuntimeException(RuntimeException ex) {
        log.error("[CommonExceptionHandler]: {}", ex.getMessage());

        return ResponseEntity.ok()
            .body(CommonRes.fail());
    }
}
