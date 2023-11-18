package com.api.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="test_address_detail")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestAddressDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mb_id")
    private Test test;

    @Column(name="address")
    private String address;

    @Column(name="address_detail1")
    private String addressDetail1;

    @Column(name="address_detail2")
    private String addressDetail2;

    @Column(name="address_detail3")
    private String addressDetail3;

}