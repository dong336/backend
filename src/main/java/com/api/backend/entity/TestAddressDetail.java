package com.api.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="test_address_detail")
@Setter
@Getter
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

    @Override
    public String toString() {
        return "TestAddressDetail [id=" + id + ", mbId=" + mbId + ", address=" + address + ", addressDetail1="
                + addressDetail1 + ", addressDetail2=" + addressDetail2 + ", addressDetail3=" + addressDetail3 + "]";
    }

    // 주인인 Test 엔터티의 필드와 매핑합니다.
    @ManyToOne
    @JoinColumn(name = "mb_id", referencedColumnName = "mb_id", insertable = false, updatable = false)
    @JsonIgnore
    private Test test;
}