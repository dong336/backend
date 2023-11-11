package com.api.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "test")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Test {
   
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mbId;

    private String mbPw;

    private String address;

    private String mbTell;

}
