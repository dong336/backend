package com.api.backend.repository;

import org.springframework.stereotype.Repository;

import com.api.backend.entity.Test;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestRepository {
    
    private final EntityManager em;
    private final JPAQueryFactory query;

    public void save(Test test) {
        em.persist(test);
    }

    public Test findOne(Long id) {
        return em.find(Test.class, id);
    }

    public List<Test> findByAddress(String address) {
        //return em.find
        return null;
    }
}
