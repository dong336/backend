package com.api.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.backend.entity.TestAddressDetail;

import java.util.List;

public interface TestAddressDetailRepository extends JpaRepository<TestAddressDetail, Long>{
    
    @Query(name = """
        SELECT ad 
        FROM Test t 
        JOIN t.addressDetails ad 
        WHERE t.mbId = :mbId
            """)
    List<TestAddressDetail> findByMbId(@Param("mbId") String mbId);
}
