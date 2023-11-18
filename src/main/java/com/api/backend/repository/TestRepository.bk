package com.api.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.backend.entity.Test;
import java.util.List;
import java.util.Map;

public interface TestRepository extends JpaRepository<Test, Long>{
    
  @Query(value = """
    select t
    from Test t
    where mbPw = :mbPw
    """)
  List<Test> findByMbPw(@Param(value = "mbPw") String mbPw);

  @Query(name = "Test.findForTest", nativeQuery = true)
  List<Map<String, Object>> findForTest(@Param(value = "id") Long id);
}
