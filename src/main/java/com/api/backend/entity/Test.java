package com.api.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "test")
@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
public class Test {
   
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="mb_id")
    private String mbId;

    @Column(name="mb_pw")
    private String mbPw;

    @Column(name="address")
    private String address;

    @Column(name="mb_tell")
    private String mbTell;
}
