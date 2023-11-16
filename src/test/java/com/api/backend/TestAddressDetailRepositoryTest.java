package com.api.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.backend.entity.TestAddressDetail;
import com.api.backend.repository.TestAddressDetailRepository;

@SpringBootTest
public class TestAddressDetailRepositoryTest {

    @Autowired
    TestAddressDetailRepository testAddressDetailRepository;

    @Test
    void testFindByMbId() {
        //given
        //when
        List<TestAddressDetail> details = testAddressDetailRepository.findByMbId("TEST00");

        //then
        assertEquals(3, details.size());
        assertEquals(1L, details.get(0).getId());
    }
}
