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
@Table(name="test_address_detail")
@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
public class TestAddressDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="mb_id")
    private String mbId;

    @Column(name="address")
    private String address;

    @Column(name="address_detail1")
    private String addressDetail1;

    @Column(name="address_detail2")
    private String addressDetail2;

    @Column(name="address_detail3")
    private String addressDetail3;

}