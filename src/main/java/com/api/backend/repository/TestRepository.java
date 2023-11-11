package com.api.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long>{
    
}
