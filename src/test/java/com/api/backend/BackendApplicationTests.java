package com.api.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.backend.repository.TestRepository;

import java.util.List;
import java.util.Map;

@SpringBootTest
class BackendApplicationTests {
		@Autowired
		private TestRepository testRepository;

    @Test
    public void testFindByMbPw() {
        // 테스트에 사용할 데이터를 저장
        com.api.backend.entity.Test test = com.api.backend.entity.Test.builder()
					.mbPw("password123")
					.build();
        testRepository.save(test);

        // 쿼리를 호출하고 결과를 받아옴
        List<com.api.backend.entity.Test> result = testRepository.findByMbPw("password123");

        // 결과 검증
        assertEquals(1, result.size());
        assertEquals("password123", result.get(0).getMbPw());
    }

    @Test
    public void testFindForTest() {
        // 테스트에 사용할 데이터를 저장
        com.api.backend.entity.Test test = com.api.backend.entity.Test.builder()
					.id(1L)
					.build();
        test.setId(1L);
        testRepository.save(test);

        // 네이티브 쿼리를 호출하고 결과를 받아옴
        List<Map<String, Object>> result = testRepository.findForTest(1L);

        // 결과 검증
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).get("id"));
        // 기타 필요한 검증 로직을 추가할 수 있습니다.
    }
}
