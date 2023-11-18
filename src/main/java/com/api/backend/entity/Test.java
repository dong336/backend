package com.api.backend.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "test")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Builder
    public Test(String mbId, String mbPw, String address, String mbTell) {
        this.mbId = mbId;
        this.mbPw = mbPw;
        this.address = address;
        this.mbTell = mbTell;
    }

    @OneToMany(mappedBy = "test_address_detail")
    private List<TestAddressDetail> orders = new ArrayList<>();
}
