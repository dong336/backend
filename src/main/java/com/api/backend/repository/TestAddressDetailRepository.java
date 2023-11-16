package com.api.backend.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.backend.entity.QTest;
import com.api.backend.entity.QTestAddressDetail;
import com.api.backend.entity.TestAddressDetail;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TestAddressDetailRepository {

    private final EntityManager em;
    private final JPAQueryFactory qf;

    public List<TestAddressDetail> findByMbId(String mbId) {
        QTest test = QTest.test;
        QTestAddressDetail testAddressDetail = QTestAddressDetail.testAddressDetail;
        
        return qf
            .select(testAddressDetail)
            .from(testAddressDetail)
            .innerJoin(test)
            .on(test.mbId.eq(testAddressDetail.mbId))
            .where(test.mbId.eq(mbId))
            .fetch();
    }
    
}
