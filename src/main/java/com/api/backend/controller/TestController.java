package com.api.backend.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend.common.CommonRes;
import com.api.backend.common.CommonResCode;
import com.api.backend.entity.Test;
import com.api.backend.exception.TestException;
import com.api.backend.repository.TestRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    
    private final TestRepository testRepository;

    @PostMapping("ping")
    public ResponseEntity<CommonRes> ping(@RequestBody HashMap<String, Object> req) throws Exception {
        List<Map<String, Object>> test = testRepository.findForTest(1L);
        Test testUnique = testRepository.findById(5L).get();

        log.info("data: {}", testUnique);
        log.info("data: {}", test);

        Map<String, Object> payload = new HashMap<>();
        
        payload.put("test", test);
        payload.put("testUnique", testUnique);
        
        if(testUnique == null)
            throw new TestException("테스트 예외 발생!");
        else 
            return ResponseEntity.ok()
                .body(CommonRes.withPayload(CommonResCode.SUCCESS, payload));
    }

    // 컨트롤러 개별 예외처리는 이렇게 한다
    @ExceptionHandler(value = TestException.class)
    public ResponseEntity<CommonRes> exceptionHandler(TestException ex) {
        log.error("[TestController]: {}" , ex.getMessage());

        return ResponseEntity.ok()
            .body(CommonRes.withPayload(CommonResCode.FAIL_TEST, null));
    }
}
